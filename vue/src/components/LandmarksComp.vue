<template>
<div class="landmarks">
  <h1>Hot Spots in Amsterdam:</h1>
    <div class="LandmarksGrid">
       <draggable class="draggable-landmarks" v-model="landmarks" group="cards" @start="drag=true" @end="drag=false" @change="addNewDestinationToItinerary(itineraryId, $event)">
      <div class="LandmarksList" v-for="(landmark, index) in landmarks" :key="index">
        <router-link :to="{ name: 'landmarkdetail', params: { id: landmark.landmark_id } }" >
          <h2 class="landmark-name">{{ landmark.name }}</h2>
        </router-link>
        <br>
        <div class="landmark-image-container">
          <img class="landmark-image" v-bind:src="landmark.imageName" />
        </div>
        <div class="landmark-description">{{ landmark.description }}</div>
        <br>
        <div>
        </div>
      </div>
      </draggable>
    </div>
  </div>
</template>

<script>

import draggable from 'vuedraggable';
import LandmarksService from '../services/LandmarksService';
import ItineraryService from '../services/ItineraryService';

export default {
  name: "landmarks",
  components: {
    draggable
  },
  data() {
    return {
      landmarks: [],
      itinerary: {},
      addedLandmarks: [],
      addedTwice: false,
      toggleButton: false

    };
  },
  computed: {
    itineraryId() {
      return this.$route.params.id;
    },
  },
  methods: {
    addNewDestinationToItinerary(itineraryId, event) {
      const landmarkId = event.removed.element.landmark_id;
      if (this.addedLandmarks.includes(landmarkId)) {
        alert('This location is already in your itinerary.');
        return;         //Only barely works, and that's if you don't refresh the page
      }

      ItineraryService.addLandmarkToUserListByItineraryId(itineraryId, landmarkId).then((response) => {

        if(response.status == 201) {
          // this.refreshItinerary();
          this.addedLandmarks.push(landmarkId);
        }
      }).catch(error => {
        console.log(error);
      })
    },
     landmarkAlreadyExistsInItinerary(landmarkId){      //Also only works if you don't refresh the page/let's you add one once that's already there.

       return this.addedLandmarks.includes(landmarkId);
        // if (this.itineraryId.includes(this.landmark.landmark_id)) {
        //   return true;
        // } else {
        //   return false;
        // }
     },
    landmarksOnMyItinerary(itineraryId) {
      LandmarksService.getLandmarksByItineraryId(itineraryId).then((response) => {
        this.landmarks = response.data;
        this.$store.commit("ADD_LANDMARK_TO_ITINERARY", this.itineraryId, this.landmarkId)
        console.log(this.landmarks);
        console.log(this.itineraryId);
      })
    }
    // refreshItinerary() {
    //   ItineraryService.getLandmarksByUserAndItineraryId().then( (response) => {
    //   this.itinerary = response.data;
 
    // })
    // }
  },
  created() {
    LandmarksService.getAllLandmarks().then( (response) => {
      this.landmarks = response.data;
      //  this.refreshItinerary(); 
    },
    

    )
  }
}
</script>

<style scoped>

h1 {
  font-size: 45px;
  margin-left: 75px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.80);
}

.LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px;
  text-decoration: none;
  margin: 20px;
}

.LandmarksList {
  border: 2px solid rgba(13, 13, 17, 0.667);
  font-family: 'Inter', sans-serif;
  border-radius: 12px;
  background-color: rgba(13, 13, 17, 0.667);
  color: white;
  padding: 10px;
}

h2.landmark-name {
  font-size: 25px;
  text-align: center;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  color: #fde75d;
}

h2.landmark-name:hover {
  color: #fea1bc;
  cursor: pointer;
}

div.landmark-image-container {
  display: flex;
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  padding-bottom: 20px;
  max-width: 280px;
  max-height: 280px;
}

.draggable-landmarks {
  display: contents; 
}
</style>