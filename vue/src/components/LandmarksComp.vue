<template>
<div class="landmarks">
  <h1>Landmarks</h1>
    <div class="LandmarksGrid">
       <draggable v-model="landmarks" group="cards" @start="drag=true" @end="drag=false" @change.self="addNewDestinationToItinerary(itineraryId, landmark.landmark_id)">
      <div
        class="LandmarksList"
        v-for="landmark in landmarks"
        :key="landmark.landmark_id"
       
      >
        <router-link
          :to="{ name: 'landmarkdetail', params: { id: landmark.landmark_id } }"
        >
          <h2>{{ landmark.name }}</h2>
        </router-link>
        <div class="landmark-image-container">
          <img class="landmark-image" v-bind:src="landmark.imageName" />
        </div>
        <div class="landmark-description">{{ landmark.description }}</div>
        <br>
        <div>
        </div>
        <!-- <button @click="addNewDestinationToItinerary(itineraryId, landmark.landmark_id)" v-if="showAddButton && $store.state.token !== ''">Add Landmark to Itinerary</button> -->
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
    showAddButton() {
      return this.$route.name === 'myitinerary';
    },
    
  },
  methods: {
    addNewDestinationToItinerary(itineraryId, landmarkId) {

      console.log(this.itineraryId);

      if (this.addedLandmarks.includes(landmarkId)) {
        alert('This location is already in your itinerary.');
        return;         //Only barely works, and that's if you don't refresh the page
      }

      ItineraryService.addLandmarkToUserListByItineraryId(itineraryId, landmarkId).then((response) => {

        if(response.status == 201) {
          // this.refreshItinerary();
            console.log(this.itineraryId);
          this.addedLandmarks.push(landmarkId);
          alert('This location has been added to your itinerary!');
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
.LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 40px;
  text-decoration: none;
}

.LandmarksList {
  border: 2px solid #2ac1d7;
  padding: 20px;
  font-family: 'Inter', sans-serif;
}

h2 {
  font-size: 20px;
}

div.landmark-image-container {
  display: flex;
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  padding-bottom: 20px;
  max-width: 300px;
  max-height: 300px;
}
</style>