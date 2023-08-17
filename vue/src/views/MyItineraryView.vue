<template>
  <div class="my-itinerary-vue">
    <MyItineraryComp />
    <br>
    <EditItineraryCompVue />
    <br>
    <GoogleMapsComp v-if="!isLoading"  v-bind:landmarks="landmarks"/>
    <br>
     <ItineraryLandmarksToVisitComp v-if="!isLoading" v-bind:landmarks="landmarks"/>
     <LandmarksComp />
     </div>
  

</template>

<script>

import MyItineraryComp from "../components/MyItineraryComp.vue";
import LandmarksComp from "../components/LandmarksComp.vue";
import ItineraryLandmarksToVisitComp from "../components/ItineraryLandmarksToVisitComp.vue"
import EditItineraryCompVue from '../components/EditItineraryComp.vue';
import ItineraryService from '../services/ItineraryService';
import GoogleMapsComp from "../components/GoogleMapsComp.vue";
 

export default {
  components: {
    
    MyItineraryComp,
    ItineraryLandmarksToVisitComp,
    LandmarksComp,
     EditItineraryCompVue,
     GoogleMapsComp
    
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