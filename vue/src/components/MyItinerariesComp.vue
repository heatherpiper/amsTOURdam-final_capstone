<template>
  <div id="my-itineraries">
    <h1>My Itineraries:</h1>
    <div class="id-test">USER ID (TEST): {{ this.$store.state.user.id }}</div>
    <div class="itinerayList">
      <div
        v-for="itinerary in itinerariesByUserId"
        v-bind:key="itinerary.id"
        v-bind:itinerary="itinerary"
      >
        <ul>
          <li>Id: {{ itinerary.itineraryId }}</li>
          <li>Itinerary Name: {{ itinerary.itineraryName }}</li>
          <li>Starting Location (Address): {{ itinerary.startingLocation }}</li>
          <li>Starting Location (Latitude): {{ itinerary.latitude }}</li>
          <li>Starting Location (Longitude): {{ itinerary.longitude }}</li>
        </ul>
      </div>
    </div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "my-itineraries",
  components: {},
  data() {
    return {
      itinerariesByUserId: [],
    };
  },
  // computed: {
  //   filteredItineraries() {
  //     const itineraries = this.itineraries;

  //   }
  // },
  created() {
    ItineraryService.getItinerariesByUserId(this.$store.state.user.id).then(
      (response) => {
        this.itinerariesByUserId = response.data;
        console.log(this.itinerariesByUserId);
      }
    );
  },
};
</script>

<style>
</style>