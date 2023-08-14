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
        <button @click="addNewDestinationToItinerary()">Add Landmark to Itinerary</button>
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
  // props: ["landmarks"],
  components: {
    // draggable
  },
  data() {
    return {
      // landmarklist: this.landmarks,
      landmarks: []
    };
  },
  methods: {
  //  addLandmarkToItinerary(landmark) {            // Figure something like this out ??
  //   this.$store.commit('ADD_LANDMARK_TO_ITINERARY', landmark);
  // },
    addNewDestinationToItinerary() {
      ItineraryService.addLandmarkToUserListByItineraryId(this.itineraryId, this.landmarkId)
    }
  },
  created() {
    LandmarksService.getAllLandmarks().then( (response) => {
      this.landmarks = response.data;
      console.log(this.landmarks);
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