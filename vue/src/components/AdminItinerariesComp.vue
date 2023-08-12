<template>
  <div id="itineraries">
      <h1>(ADMIN) All Itineraries:</h1>
      <div class="id-test">
       USER ID (TEST): {{this.$store.state.user.id}}
      </div>
      <div class="itinerayList" v-for="itinerary in itineraries" v-bind:key="itinerary.id">
                    <!-- v-for="itinerary in itineraries" v-bind:key="itinerary.id" -->
        <ul>
          <li>Id: {{ itinerary.itineraryId }}</li>
          <li>Itinerary Name: {{ itinerary.itineraryName }}</li>
          <li>Starting Location (Address): {{ itinerary.startingLocation }}</li>
          <li>Starting Location (Latitude): {{ itinerary.latitude }}</li>
          <li>Starting Location (Longitude): {{ itinerary.longitude }}</li>
        </ul>
        
      </div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "admin-itineraries",
  components: {
  },
  data() {
    return {
      itineraries: []
    }
  },
    created() {
    ItineraryService.getItineraries().then((response) => {
      this.itineraries = response.data;
      console.log(this.itineraries);
      
    });
  }
}
</script>

<style>

</style>