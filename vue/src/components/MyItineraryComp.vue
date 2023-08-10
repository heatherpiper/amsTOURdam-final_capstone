<template>
  <div>
      <h1>My Intinerary:</h1>
      <div>Itinerary Name: {{ itinerary.itineraryName }}</div>
      <div>Starting Location: {{ itinerary.startingLocation }}</div>
  </div>
</template>

<script>
import ItineraryService from '@/services/ItineraryService'

export default {
  name: "my-itinerary",
  data() {
    return {
      itineraryId: 0,
      itinerary: {}

    }
  },
  created() {
    this.itineraryId = this.$route.params.id;
    ItineraryService.getMyItinerary(this.itineraryId).then(response => {
      this.itinerary = response.data;
    });
  }

}
</script>

<style>

</style>