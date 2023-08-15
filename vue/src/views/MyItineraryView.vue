<template>
  <div>
     
    <MyItineraryComp />
    <EditItineraryComp />
   
    
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
import EditItineraryComp from "../components/EditItineraryComp.vue";

// import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"

export default {
  components: {
    
    MyItineraryComp,
    EditItineraryComp,
    // ItineraryLandmarksToVisitComp,
    LandmarksComp,
    
  },
};
</script>

<style>
</style>