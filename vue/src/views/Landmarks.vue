<template>
  <div class="landmarksvue">
    <h1>Landmarks</h1>
    <br />
    <GoogleMapsComp v-if="!isLoading" v-bind:landmarks="landmarks" />
    <LandmarksComp v-if="!isLoading" v-bind:landmarks="landmarks" />
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

<style scoped>

div.landmarksvue {
  background-color: #F1EFF9;
}
div.landmarksvue h1 {
  text-align: center;
  font-size: 60px;
  border: 2px solid #519BCB;
  font-family: Georgia, "Times New Roman", Times, serif;
  background-color: white;
  width: 400px;
  margin: 0 auto;
  border-radius: 5px;
}
</style>