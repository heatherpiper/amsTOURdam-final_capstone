<template>
  <div class="my-itinerary-vue">
    <MyItineraryComp />
    <br>
    <EditItineraryCompVue />
    <br>
    <br>
     <ItineraryLandmarksToVisitComp v-if="!isLoading" v-bind:landmarks="landmarks"/>
    <br>
    <!-- <GoogleMapsComp v-bind:landmarks="landmarks"/> -->
    <br>
     <LandmarksComp />
     </div>
  

</template>

<script>

import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"
import EditItineraryCompVue from '../components/EditItineraryComp.vue';
import ItineraryService from '../services/ItineraryService';

export default {
  components: {
    
    MyItineraryComp,
    ItineraryLandmarksToVisitComp,
    LandmarksComp,
     EditItineraryCompVue,
    
  },
   data() {
    return {
      landmarks: [],
      itinerary: [],
      isLoading: true,
    };
  },
  created() {

    this.userId = this.$store.state.user.id;
    console.log(this.userId);
    const selectedItineraryId = this.$route.params.id;
    console.log(selectedItineraryId);
    ItineraryService.getLandmarksByUserAndItineraryId(this.userId, selectedItineraryId).then( (response) => {
      this.landmarks = response.data;
      this.itinerary = response.data;
      this.isLoading = false;

      console.log(this.landmarks);
      console.log(this.itinerary);
        // this.refreshItinerary();

    })
  }
};
</script>

<style>
</style>