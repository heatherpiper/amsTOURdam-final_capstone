<template>
<div class="landmarks">
    <div class="LandmarksGrid">
        <h1>Landmarks On My Itinerary: </h1>
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
        <!-- <div class="landmark-image-container">
          <img class="landmark-image" v-bind:src="landmark.imageName" />
        </div> -->
        <!-- <div class="landmark-description">{{ landmark.description }}</div> -->
        <br>
        <!-- <button @click="addLandmarkToItinerary(landmark)">Add Landmark to Itinerary</button> -->
      </div>
    </div>
  </div>
</template>

<script>

import ItineraryService from "@/services/ItineraryService.js";

  
export default {
  name: "landmarks",
  // props: ["landmarks"],
  components: {
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
    
  },
  created() {
    this.userId = this.$store.state.user.id;
    console.log(this.userId);
    const selectedItineraryId = this.$route.params.id;
    console.log(selectedItineraryId);
    ItineraryService.getLandmarksByUserAndItineraryId(this.userId, selectedItineraryId).then( (response) => {
      this.landmarks = response.data;
      console.log(this.landmarks);
    }

    )
  }
}
</script>

<style scoped>
/* .LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 40px;
  text-decoration: none;
} */

.LandmarksList {
  /* border: 2px solid #2ac1d7;
  padding: 20px; */
  font-family: 'Inter', sans-serif;
}

h2 {
  font-size: 20px;
}

div.landmark-image-container {
  /* display: flex; */
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  padding-bottom: 20px;
  max-width: 300px;
  max-height: 300px;
}
</style>