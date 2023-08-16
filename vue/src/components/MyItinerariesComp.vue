<template>
  <div id="my-itineraries">
    <!-- <EditItineraryCompVue /> -->
    <div>
    <h1>My Itineraries:</h1>
    </div>
    <br>
    <!-- <div class="id-test">USER ID (TEST): {{ this.$store.state.user.id }}</div> -->
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
          <!-- <li class="info-item">Itinerary Id: {{ itinerary.itineraryId }}</li> -->
          <li class="info-item" id="itinerary-name">Itinerary Name: {{ itinerary.itineraryName }}</li>
          <li class="info-item">Starting Location (Address): {{ itinerary.startingLocation }}</li>
        </ul>
        </router-link>
      
        
        <!-- <button  v-on:click="$router.push('myitinerary/'+itinerary.itineraryId)"  value="Edit Itinerary" >Edit Itinerary</button> -->
        <button  v-on:click="deleteItinerary(itinerary.itineraryId)" >Delete Itinerary</button>
      </div>
    </div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";
// import EditItineraryCompVue from '../components/EditItineraryComp.vue';

export default {
  name: "my-itineraries",
  components: {
    // EditItineraryCompVue
  },
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
  gap: 20px; /* Add some gap between grid items */
}

.itinerary-box {
  align-items: center;
  padding: 20px;
  border: 2px solid;
  background-color: #519BCB;
  border-radius: 5px;
  width: 90%; /* Remove width property */
  margin: 20px;
}

#itinerary-name {
  font-weight: bold;
  font-size: 20px
}

li.info-item {
  color: white;
  font-size: 15px;
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


</style>