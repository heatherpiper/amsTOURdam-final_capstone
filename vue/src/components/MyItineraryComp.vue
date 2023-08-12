<template>
  <div>
    <h1>My Intinerary: </h1>
    <div>Itinerary Name: {{ itinerary.itineraryName }}</div>
    <div>Starting Location: {{ itinerary.startingLocation }}</div>
    <div>Latitude: {{ itinerary.latitude }}</div>
    <div>Longitude: {{ itinerary.longitude }}</div>
    <div>{{ this.$store.state.itinerary.itineraryId }}</div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";

export default {
  name: "my-itinerary",
  //props: ['itinerary'],
  data() {
    return {
      itinerary: {
        itineraryId: "",
        itineraryName: "",
        startingLocation: "",
        latitude: "",
        longitude: "",
      }
    };
  },
  created() {
    ItineraryService.getMyItinerary(this.$store.state.itinerary.itineraryId).then((response) => {
      this.itinerary = response.data;
      
      console.log(this.itinerary);
    }).catch( err => console.error(err) );
  },
};
</script>

<style>
</style>