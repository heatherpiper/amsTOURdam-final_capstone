<template>
  <div>
    <MyItineraryComp />
    <br>
    <br>
     <ItineraryLandmarksToVisitComp />
    <br>
    <br>
     <LandmarksComp />
     </div>
  

</template>

<script>

import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"

export default {
  components: {
    
    MyItineraryComp,
    ItineraryLandmarksToVisitComp,
    LandmarksComp,
    
  },
};
</script>

<style>
</style>