<template>
  <div>
    <h1>My Intinerary:</h1>
    <div>Itinerary Name: {{ itinerary.itineraryName }}</div>
    <div>Starting Location: {{ itinerary.startingLocation }}</div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";

export default {
  name: "my-itinerary",
  data() {
    return {
      itineraryId: 0,
      itinerary: {}
    };
  },
  created() {
    ItineraryService.getMyItinerary(this.$store.state.itinerary.id).then((response) => {
      this.itinerary = response.data;
      console.log(this.itinerary);
    });
  },
};
</script>

<style>
</style>