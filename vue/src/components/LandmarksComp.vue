<template>
<div class="landmarks">
    <div class="LandmarksGrid">
       <!-- <draggable v-model="landmarklist" @start="drag=true" @end="drag=false"> -->
      <div
        class="LandmarksList"
        v-for="landmark in landmarklist"
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
        <button @click="addLandmarkToItinerary(landmark)">Add Landmark to Itinerary</button>
      </div>
      <!-- </draggable> -->
    </div>
  </div>
</template>

<script>
// import draggable from 'vuedraggable';

export default {
  name: "landmarks",
  props: ["landmarks"],
  components: {
    // draggable
  },
  data() {
    return {
      landmarklist: this.landmarks,
    };
  },
  methods: {
   addLandmarkToItinerary(landmark) {     // Implement something like this for button above ???
      this.landmarklist.push(landmark);
    },
  },
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