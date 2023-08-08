<template>
  <div class="landmarks">
    <LandmarksComp v-bind:landmarks="landmarks"/>
    <h1>Landmarks</h1>
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
          landmarks: []
      }
    },
    created() {
        LandmarksService.getAllLandmarks().then( response => {
        this.landmarks = response.data;
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