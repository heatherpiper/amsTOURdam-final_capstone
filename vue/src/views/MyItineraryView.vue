<template>
  <div>
    <MyItineraryComp />
    <!-- <ItineraryLandmarksToVisitComp /> -->
    <br>
    <br>
    <h1>Add Landmarks To Itinerary:</h1>
     <LandmarksComp />
  </div>

</template>

<script>
import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
// import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"

export default {
  components: {
    
    MyItineraryComp,
    // ItineraryLandmarksToVisitComp,
    LandmarksComp,
  },
};
</script>

<style>
</style>