<template>
<div class="landmarks">
    <div>
      <h1>Landmarks On My Itinerary: </h1>
    </div>

    <div class="LandmarksGrid">
        <h1>Landmarks On My Itinerary: </h1>
         <draggable v-model="landmarks" group="cards" @start="drag=true" @end="drag=false">
      <div class="LandmarksList" v-for="landmark in landmarks" :key="landmark.landmark_id" >
        <router-link :to="{ name: 'landmarkdetail', params: { id: landmark.landmark_id } }" >
          <h2>{{ landmark.name }}</h2>
        </router-link>
        <!-- <div class="landmark-image-container">
          <img class="landmark-image" v-bind:src="landmark.imageName" />
        </div> -->
        <!-- <div class="landmark-description">{{ landmark.description }}</div> -->
        <br>
      </div>
        <div>
      </div>
      </draggable>
    </div>
  </div>
</template>

<script>
import draggable from 'vuedraggable';
import ItineraryService from "@/services/ItineraryService.js";
  
export default {
  name: "landmarks",
  components: {
    draggable

  },
  data() {
    return {
      landmarks: [],
      itinerary: []
    };
  },
  computed: {
     itineraryId() {
      return this.$route.params.id;
    }
  },
  methods: {
    //   refreshItinerary() {
    //   ItineraryService.getLandmarksByUserAndItineraryId().then( (response) => {
    //   this.itinerary = response.data;
    //   })
    // },

  },
  created() {
    this.userId = this.$store.state.user.id;
    console.log(this.userId);
    const selectedItineraryId = this.$route.params.id;
    console.log(selectedItineraryId);
    ItineraryService.getLandmarksByUserAndItineraryId(this.userId, selectedItineraryId).then( (response) => {
      this.landmarks = response.data;
      this.itinerary = response.data;
      console.log(this.landmarks);
      console.log(this.itinerary);
        // this.refreshItinerary();

    })
  }
}
</script>

<style scoped>
.LandmarksGrid {
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(300px, 1fr));
  gap: 5px;
  text-decoration: none;
}

.LandmarksList {
  /* border: 2px solid #2ac1d7; */
  padding: 20px;
  font-family: 'Inter', sans-serif;
}


h2 {
  font-size: 17px;
}

/* div.landmark-image-container {
  /* display: flex; */
/* } */ 

img.landmark-image {
  display: block;
  margin: 0 auto;
  padding-bottom: 20px;
  max-width: 300px;
  max-height: 300px;
}
</style>