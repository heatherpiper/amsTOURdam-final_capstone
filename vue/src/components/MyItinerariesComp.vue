<template>
  <div id="my-itineraries">
    <div>
    <h1>My Itineraries:</h1>
    </div>
    <br>
    <!-- <div class="id-test">USER ID (TEST): {{ this.$store.state.user.id }}</div> -->
    <br>
    <div class="itineray-grid">
      <router-link
        v-for="itinerary in itinerariesByUserId"
        v-bind:key="itinerary.id"
        v-bind:itinerary="itinerary"
        :to="`/myitinerary/${itinerary.itineraryId}`"
        class="itinerary-item"
      >
      <div class="itinerary-box">
        <ul class="itinerary-info">
          <li class="info-item">Id: {{ itinerary.itineraryId }}</li>
          <li class="info-item">Itinerary Name: {{ itinerary.itineraryName }}</li>
          <li class="info-item">Starting Location (Address): {{ itinerary.startingLocation }}</li>
          <li class="info-item">Starting Location (Latitude): {{ itinerary.latitude }}</li>
          <li class="info-item">Starting Location (Longitude): {{ itinerary.longitude }}</li>
          <input type="button" value="Edit Itinerary" />
          <input v-on:click="deleteItinerary(itineraryId)" type="button" value="Delete Itinerary" />
        </ul>
      </div>
      </router-link>
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
  created() {
    ItineraryService.getItinerariesByUserId(this.$store.state.user.id).then(
      (response) => {
        this.itinerariesByUserId = response.data;
        console.log(this.itinerariesByUserId);
      }
    );
  },
  methods: {
    deleteItinerary(itineraryId){
      itineraryId = this.itinerary.itineraryId
      this.ItineraryService.deleteItinerary(itineraryId)
      .then(()=>{
        //re-display user list of itineraries
        this.getItinerariesByUserId();
      });
    }
  }
};
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 60px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
}

.itinerary-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 40px;
  justify-content: center;
}

.itinerary-item {
  text-decoration: none;

}

.itinerary-box {
  align-items: center;
  padding: 20px;
  border: 2px solid;
  color: #519BCB;
  background-color: #ffffffdd;
  border-radius: 5px;
  margin: 10px; 

}

div.itinerary-box:hover {
  color: darksalmon;
}

ul.itinerary-info {
  list-style: none;
  padding: 0;
  margin: 0;
  font-size: 20px;
  text-align: left;
  display: flex;
  flex-direction: column;
}

.info-item {
  padding: 5px 0;
}


</style>