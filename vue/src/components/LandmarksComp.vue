<template>
<div class="landmarks">
    <div class="LandmarksGrid">
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
        <main>{{ landmark.description }}</main>
      </div>
    </div>
    <draggable v-model="landmarklist" group="destinations" @start="drag=true" @end="drag=false">
      <div v-for="element in landmarklist" :key="element.id">{{element.name}}</div>
    </draggable>
  </div>
</template>

<script>
import draggable from 'vuedraggable';

export default {
  name: "landmarks",
  props: ["landmarks"],
  components: {
    draggable
  },
  data() {
    return {
      landmarklist: this.landmarks,
    };
  },
  methods: {
   
  },
}
</script>

<style scoped>
.LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 40px;
}

.LandmarksList {
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  padding: 20px;
  background-color: rgb(231, 163, 17);
  color: rgb(58, 2, 58);
  font-family: Georgia, "Times New Roman", Times, serif;
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
  max-width: 300px;
  max-height: 300px;
}
</style>