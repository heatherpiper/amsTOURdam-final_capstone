<template>
  <div id="my-itineraries">
    <div>
    <h1>My Amsterdam Itineraries:</h1>
    </div>
    <br>
    <h2>Click on an Itinerary to Add Locations to Visit:</h2>
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
          <br>
          <li class="info-item" id="itinerary-starting-location-title">Starting Location: </li>
          <li class="info-item" id="itinerary-starting-location">{{ itinerary.startingLocation }}</li>
        </ul>
        <br>
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
  border-bottom: 2px solid;
  border-top: 2px solid;
  margin: 0 auto;
  color: #2ac1d7;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

h2 {
  text-align: center;
  color: rgba(13, 13, 17, 0.667);
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
  background-color: rgba(13, 13, 17, 0.667);
  border-radius: 5px;
  /* width: 90%;  */
  margin: 20px;
}

#itinerary-name {
  font-weight: bold;
  font-size: 25px;
  line-height: 25px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  padding: 5px;
  color: rgba(13, 13, 17, 0.667);
}

#itinerary-starting-location-title {
  font-weight: 600;
   font-size: 20px;
}

#itinerary-starting-location {
  font-size: 17px;
}

li.info-item {
  color: white;
  font-size: 15px;
  font-family: 'Bricolage Grotesque', sans-serif;
}

div.itinerary-box:hover {
  color: #FDE75D;
}

ul.itinerary-info {
  list-style: none;
  padding: 0;
  margin: 0;
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
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.delete-button:hover {
  color: #2ac1d7;
  cursor: pointer;
}

</style>