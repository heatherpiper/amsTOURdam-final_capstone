<template>
  <div class="landmarksvue">
    <h1>Landmarks</h1>
    <br>
    <LandmarksComp v-if=" !isLoading " v-bind:landmarks="landmarks"/>
  </div>
</template>
<script>

import LandmarksComp from '../components/LandmarksComp.vue'
import LandmarksService from '../services/LandmarksService'

export default {
    components: {
        LandmarksComp,
        
    },
    data() {
      return {
          landmarks: [],
          isLoading: true
      }
    },
    created() {
        LandmarksService.getAllLandmarks().then( response => {
        this.landmarks = response.data;
        this.isLoading = false;
        console.log(this.landmarks);
        })
    }
}
</script>

<style scoped>
div.landmarksvue h1 {
  text-align: center;
  font-size: 60px;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, 'Times New Roman', Times, serif;
  background-color: rgb(231, 163, 17);
  width: 400px;
  margin: 0 auto;
  border-radius: 5px;
  
}
</style>