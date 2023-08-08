<template>
  <div class="landmarks">
    <h1>Landmarks</h1>
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
<style>
h1 {
  text-align: center;
  font-family: arial Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>