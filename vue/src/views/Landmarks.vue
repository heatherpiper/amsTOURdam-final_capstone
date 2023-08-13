<template>
  <div class="landmarksvue">
    <h1>Landmarks</h1>
    <br />
    <GoogleMapsComp v-if="!isLoading" v-bind:landmarks="landmarks" />
    <LandmarksComp v-if="!isLoading" v-bind:landmarks="landmarks"/>
  </div>
</template>

<script>
import LandmarksComp from "../components/LandmarksComp.vue";
import LandmarksService from "../services/LandmarksService";
import GoogleMapsComp from "../components/GoogleMapsComp.vue";



export default {

  components: {
    LandmarksComp,
    GoogleMapsComp,
    
  },
  data() {
    return {
      landmarks: [],
      isLoading: true,
    };
  },
  created() {
    LandmarksService.getAllLandmarks().then((response) => {
      this.landmarks = response.data;
      this.isLoading = false;
      console.log(this.landmarks);
    });
  },
};

</script>

<style>

</style>