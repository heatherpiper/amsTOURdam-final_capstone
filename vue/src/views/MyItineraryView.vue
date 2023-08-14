<template>
  <div>
    <MyItineraryComp />
    <br>
     <LandmarksComp />
  </div>

</template>

<script>
import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";


export default {
  components: {
    
    MyItineraryComp,
    LandmarksComp,
  },
};
</script>

<style>
</style>