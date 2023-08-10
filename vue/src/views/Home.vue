<template>
  <div class="home">
    <h1>Welcome To Amsterdam!</h1>
    <br>
    <br>
    <div class="googlemap-container">
      <LandmarksComp v-if="!isLoading" v-bind:landmarks="landmarks" />
      <GoogleMapsCompVue v-if="!isLoading" v-bind:landmarks="landmarks" />
      <Landmarks />  
    </div>
  </div>
</template>

<script>

import GoogleMapsCompVue from "../components/GoogleMapsComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
import Landmarks from "@/views/Landmarks.vue";


export default {
  name: "home",
  components: {
    GoogleMapsCompVue,
    LandmarksComp,
    Landmarks
  },
  data() {
    return {
      landmarks: [],
      isLoading: true,
    }
  }
  };
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 60px;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, 'Times New Roman', Times, serif;
  background-color: rgb(231, 163, 17);
  width: 800px;
  margin: 0 auto;
  border-radius: 5px;
  
}

div home {
  position: relative;
}

div .googlemap-container {
  position: absolute;
  left: 35%;
  width: 800px;
  height: 500px;
  
}
#map {
width: 500px;
height: 500px;

}

</style>
