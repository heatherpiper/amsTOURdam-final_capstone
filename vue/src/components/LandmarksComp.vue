<template>
  <div id="landmarks">
    <div class="LandmarksGrid">
      <div class="LandmarksList" v-for="landmark in landmarks" :key="landmark.landmark_id">
        <router-link :to="{ name: 'landmarkdetail', params: { id: landmark.landmark_id } }">
          <h1>{{ landmark.name }}</h1>
        </router-link>
        <img class="landmark-image" v-bind:src="require('../media/assets/' + landmark.imageName)" alt="">
        <h2>{{ landmark.description }}</h2>

      </div>
    </div>
  </div>
</template>

<script>
export default {
name: "landmarks",
props: ['landmarks']
}
</script>

<style scoped>
.LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr)); 
  gap: 20px; 
}

.LandmarksList {
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  padding: 20px;
  background-color: rgb(231, 163, 17);
  color: rgb(58, 2, 58);
  font-family: Georgia, 'Times New Roman', Times, serif;
}

h2 {
  font-size: 19px;
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  width: 300px;

}
</style>