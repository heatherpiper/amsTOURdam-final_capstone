<template>
  <div class="landmarks">
    <div>
      <h1>Landmarks On My Itinerary:</h1>
    </div>

    <div class="LandmarksList">
      <draggable class="draggable-landmarks" v-model="landmarks" group="cards" @start="drag = true" @end="drag = false">
        <div class="landmark-card" v-for="landmark in landmarks" :key="landmark.landmark_id">
          <router-link :to="{ name: 'landmarkdetail', params: { id: landmark.landmark_id }}">
            <h2>{{ landmark.name }}</h2>
          </router-link>
          <div class="landmark-image-container">
            <img class="landmark-image" v-bind:src="landmark.imageName" />
          </div>
        </div>
      </draggable>
    </div>
  </div>
</template>

<script>
import draggable from "vuedraggable";
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "landmarks",
  components: {
    draggable,
  },
  data() {
    return {
      landmarks: [],
      itinerary: [],
    };
  },
  computed: {
    itineraryId() {
      return this.$route.params.id;
    },
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
    ItineraryService.getLandmarksByUserAndItineraryId(
      this.userId,
      selectedItineraryId
    ).then((response) => {
      this.landmarks = response.data;
      this.itinerary = response.data;
      console.log(this.landmarks);
      console.log(this.itinerary);
      // this.refreshItinerary();
    });
  },
};
</script>

<style scoped>
.LandmarksList {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start; /* Keeps cards aligned at the top of each row */
}

.landmark-card {
  width: calc(9.33% - 1px);
  border: 2px solid #2ac1d7;
  margin: 4px;
  padding: 4px;
  font-family: "Inter", sans-serif;
  box-sizing: border-box; /* Includes padding in width calculation */
}

h1 {
  font-size: 30px;
  margin: 12px;
}

h2 {
  font-size: 17px;
  text-align: center;
}

.landmark-image-container {
  display: flex;
  justify-content: center;
}

img.landmark-image {
  width: 5vw;
  height: 5vw;
  display: flex;
}

.draggable-landmarks {
  display: contents; 
}

</style>