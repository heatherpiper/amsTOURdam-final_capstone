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
          <li class="info-item">Id: {{ itinerary.itineraryId }}</li>
          <li class="info-item">Itinerary Name: {{ itinerary.itineraryName }}</li>
          <li class="info-item">Starting Location (Address): {{ itinerary.startingLocation }}</li>
          <li class="info-item">Starting Location (Latitude): {{ itinerary.latitude }}</li>
          <li class="info-item">Starting Location (Longitude): {{ itinerary.longitude }}</li>
        </ul>
        </router-link>
      
        
        <button  v-on:click="$router.push('myitinerary/'+itinerary.itineraryId)"  value="Edit Itinerary" >Edit Itinerary</button>
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
  flex: 0 0 calc(33.33% - 20px);
  width: 365px;

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
  font-size: 15px;
}


</style>