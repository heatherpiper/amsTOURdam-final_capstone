<template>
  <div class="landmarks">
    <div>
      <h1>Locations Added to My Itinerary:</h1>
    </div>

    <div class="Landmarks-List">
      <draggable
        class="draggable-landmarks"
        v-model="landmarks"
        group="cards"
        @start="drag = true"
        @end="drag = false"
        @change="deleteDestinationFromItinerary(itineraryId, $event)"
      >
        <div
          class="landmark-card"
          v-for="(landmark, index) in landmarks"
          :key="index"
        >
          <router-link
            :to="{
              name: 'landmarkdetail',
              params: { id: landmark.landmark_id },
            }"
          >
            <h2>{{ landmark.name }}</h2>
          </router-link>
          <div class="landmark-image-container">
            <img class="landmark-image" v-bind:src="landmark.imageName" />
          </div>
        </div>
      </draggable>
      <div>
        <p>Drag Locations Here to Add to Your Itinerary!</p>
      </div>
    </div>
  </div>
</template>

<script>
import draggable from "vuedraggable";
import ItineraryService from "@/services/ItineraryService.js";

export default {
  name: "landmarks-list",
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
    deleteDestinationFromItinerary(itineraryId, event) {
      const landmarkId = event.removed.element.landmark_id;
      ItineraryService.removeLandmarkFromItineraryByLandmarkId(
        itineraryId,
        landmarkId
      ).then((response) => {
        if (response.status == 204) {
          this.landmarks.pop(landmarkId);
        }
      });
    },
  },
  //   refreshItinerary() {
  //   ItineraryService.getLandmarksByUserAndItineraryId().then( (response) => {
  //   this.itinerary = response.data;
  //   })
  // },
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
.Landmarks-List {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;
  align-items: flex-start;
  padding: 150px;
  border: 2px solid #2ac1d7;
  margin: 20px;
  width: 95vw;
  background-color: gray;
  border-radius: 10px;
  height: minmax(400px);
}

.landmark-card {
  width: calc(9.33% - 1px);
  border: 2px solid #2ac1d7;
  margin: 4px;
  padding: 4px;
  font-family: "Inter", sans-serif;
  box-sizing: border-box;
  height: 150px;
  background-color: white;
}

.landmark-card:hover {
  cursor: pointer;
  border-color: darksalmon;
}

h1 {
  font-size: 45px;
  margin-left: 75px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

h2 {
  display: flex;
  font-size: 90%;
  text-align: center;
}

div p {
  text-align: center;
  margin: 0 auto;
  font-weight:lighter;
  color: white;
  font-family: 'Bricolage Grotesque', sans-serif;
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