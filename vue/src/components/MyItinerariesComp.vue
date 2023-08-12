<template>
  <div id="itineraries">
      <h1>My Itineraries:</h1>
      <div class="itenerayList">
        <MyItinerary v-for="itinerary in itineraries"
        v-bind:key="itinerary.userId"
        v-bind:itinerary="itinerary" />
        {{itinerary.itineraryName}}
      </div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";
import MyItinerary from "@/components/MyItineraryComp.vue"

export default {
  name: 'itinerary-list',
  components: {
    MyItinerary
  },
  data() {
    return {
      userId: 0,
      itineraries: []
    }
  },
  //   created() {
  //   ItineraryService.getItineraries().then((response) => {
  //     this.itineraries = response.data;
  //     console.log(this.itineraries);
      
  //   });
  // },
  created() {
    ItineraryService.getItinerariesByUserId(this.userId).then((response) => {
      this.itineraries = response.data;
      console.log(this.itineraries);
    });
  }
}
</script>

<style>

</style>