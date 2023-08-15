<template>
  <div>
    <MyItineraryComp />
    <br>
    <GoogleMapsComp />
    <br>
     <ItineraryLandmarksToVisitComp />
    <br>
    <br>
     <LandmarksComp />
     </div>
  

</template>

<script>

import GoogleMapsComp from "../components/GoogleMapsComp.vue";
import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"

export default {
  components: {
    
    MyItineraryComp,
    ItineraryLandmarksToVisitComp,
    LandmarksComp,
    GoogleMapsComp
    
  },
};
</script>

<style>
</style>