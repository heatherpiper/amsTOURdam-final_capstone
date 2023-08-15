<template>
<div class="landmarks">
    <div class="LandmarksGrid">
       <!-- <draggable v-model="landmarklist" @start="drag=true" @end="drag=false"> -->

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
        <button @click="addNewDestinationToItinerary(itineraryId, landmark.landmark_id)" v-if="$store.state.token !== ''">Add Landmark to Itinerary</button>
      </div>
      <!-- </draggable> -->
    </div>
  </div>
</template>

<script>

// import draggable from 'vuedraggable';
import LandmarksService from '../services/LandmarksService';
import ItineraryService from '../services/ItineraryService';
  
export default {
  name: "landmarks",
  components: {
    // draggable
  },
  data() {
    return {
      landmarks: [],
      itinerary: [],
      addedLandmarks: []
    };
  },
  computed: {
    itineraryId() {
      return this.$route.params.id;
    }
  },
  methods: {
    addNewDestinationToItinerary(itineraryId, landmarkId) {

      if (this.addedLandmarks.includes(landmarkId)) {
        alert('This location is already in your itinerary.');
        return;         //Only works if you don't refresh the page
      }

      ItineraryService.addLandmarkToUserListByItineraryId(itineraryId, landmarkId).then((response) => {

        if(response.status == 201) {
          // this.refreshItinerary();
          this.addedLandmarks.push(landmarkId);
          alert('This location has been added to your itinerary!');
        }
      }).catch(error => {
        console.log(error);
      })
    },
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

    }

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