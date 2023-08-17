<template>
<div>
  <div>
    <h1>Explore Locations in Amsterdam:</h1>
  </div>
  <div class="landmarksvue">
    <GoogleMapsComp v-if="!isLoading" v-bind:landmarks="landmarks" />
    <br>
    <br>
    <LandmarksComp v-if="!isLoading" v-bind:landmarks="landmarks"/>
  </div>
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

h1 {
  text-align: center;
  font-size: 60px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}


</style>