<template>
  <div id="my-itinerary">
    <h1>My Intinerary: </h1>
    <div>Itinerary Id: {{ itinerary.itineraryId }}</div>
    <div>Itinerary Name: {{ itinerary.itineraryName }}</div>
    <div>Starting Location (Address) {{ itinerary.startingLocation }}</div>
    <div>Starting Location (Latitude): {{ itinerary.startingLocationLatitude }}</div>
    <div>Starting Location (Longitude): {{ itinerary.startingLocationLongitude }}</div>
    <div>TESTING ITINERARY ID: {{ this.$route.params.id }}</div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "my-itinerary",
  //props: ['itinerary'],
  data() {
    return {
      itinerary: {
        itineraryId: "",
        itineraryName: "",
        startingLocation: "",
        startingLocationLatitude: "",
        startingLocationLongitude: "",
      }
    };
  },
  created() {
    const selectedItineraryId = this.$route.params.id;
    console.log(selectedItineraryId);
    ItineraryService.getMyItinerary(selectedItineraryId).then((response) => {
      if (response.status === 200) {
            if (response.data) {
              this.itinerary = response.data;
              console.log(this.itinerary);
            } else {
              console.error("Response data is missing 'id' property:", response.data);
            }
          } else {
            console.error("Unexpected status code:", response.status);
          }
        })
        .catch((err) => console.error("API Error:", err));
  },
};
</script>

<style>
</style>