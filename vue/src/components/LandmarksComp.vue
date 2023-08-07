<template>
  <div id="landmarks">
    <h1>Landmarks</h1>
    <div class="LandmarksList">
      <landmark-detail v-for="landmark in landmarks" v-bind:key="landmark.landmarkId" v-bind:landmark="landmarks"/>
    </div>
  </div>
</template>

<script>
import LandmarksService from '../services/LandmarksService'
import LandmarkDetail from './LandmarkDetailComp.vue'

export default {
name: "landmarks",
components: {
  LandmarkDetail
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

</style>