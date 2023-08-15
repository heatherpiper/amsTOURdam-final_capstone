<template>
  <div>
    <MyItineraryComp />
    <br>
    <EditItineraryCompVue />
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
import EditItineraryCompVue from '../components/EditItineraryComp.vue';

export default {
  components: {
    
    MyItineraryComp,
    ItineraryLandmarksToVisitComp,
    LandmarksComp,
     EditItineraryCompVue,
    
  },
};
</script>

<style>
</style>