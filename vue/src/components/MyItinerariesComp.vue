<template>
  <div>
      <h1>My Itineraries:</h1>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";

export default {
      data() {
    return {
      itineraries: {}
    };
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