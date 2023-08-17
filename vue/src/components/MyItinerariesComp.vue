<template>
  <div id="my-itineraries">
    <div>
    <h1>My Amsterdam Itineraries:</h1>
    </div>
    <br>
    <br>
    <div class="itinerary-grid">
      
      <div class="itinerary-box"  v-for="itinerary in itinerariesByUserId"
        v-bind:key="itinerary.id"
        v-bind:itinerary="itinerary"
        >
        <router-link
       :to="`/myitinerary/${itinerary.itineraryId}`"
        class="itinerary-item"
      >
        <ul class="itinerary-info">
          <li class="info-item" id="itinerary-name"> {{ itinerary.itineraryName }}</li>
          <li class="info-item">Starting Location (Address): {{ itinerary.startingLocation }}</li>
        </ul>
        </router-link>
          <div class="delete-button-container">
            <button class="delete-button" v-on:click="deleteItinerary(itinerary.itineraryId)" >Delete Itinerary</button>
          </div>
      </div>
    </div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "my-itineraries",

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
      ItineraryService.deleteItinerary(itineraryId)
      .then((response)=>{
        if (response.status == 204) {
          this.getItineraries()
        }
      });
    },
    getItineraries() {
      ItineraryService.getItinerariesByUserId(this.$store.state.user.id).then(
      (response) => {
        this.itinerariesByUserId = response.data;
        
      }
    );
    }
  }
};
</script>

<style scoped>

* {
  box-sizing: border-box;
}

h1 {
  text-align: center;
  font-size: 60px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
}

.itinerary-item {
  text-decoration: none;

}

.itinerary-grid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 20px; 
}

.itinerary-box {
  align-items: center;
  padding: 20px;
  border: 2px solid;
  background-color: #519BCB;
  border-radius: 5px;
  width: 90%; 
  margin: 20px;
}

#itinerary-name {
  font-weight: bold;
  font-size: 20px
}

li.info-item {
  color: white;
  font-size: 15px;
  font-family: 'Bricolage Grotesque', sans-serif;
}

div.itinerary-box:hover {
  color: darksalmon;
}

ul.itinerary-info {
  list-style: none;
  padding: 0;
  margin: 0;
  font-size: 20px;
  text-align: center;
  display: flex;
  flex-direction: column;
}

.info-item {
  padding: 5px 0;
  font-size: 15px;
}

.delete-button-container {
  text-align: center;
  padding-top: 10px;
}

.delete-button {
  border-radius: 15px;
  color: white;
  background-color: rgba(13, 13, 17, 0.667);
  padding: 6px;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.delete-button:hover {
  color: darksalmon;
  cursor: pointer;
}

</style>