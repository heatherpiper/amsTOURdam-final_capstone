<template>
  <div>
    <div id="my-itineraries-button">
      <router-link
        class="navlink"
        @click.prevent.stop
        v-bind:to="{ name: 'myitineraries' }"
        v-if="$store.state.token !== ''"
      >
        <div>
          <h4 class="return-to-itineraries-header">Return To My Itineraries</h4>
        </div>
        <br />
      </router-link>
    </div>
    <div id="my-itinerary">
      <h1 class="my-itinerary-header">My Intinerary:</h1>
      <div class="info-item">Itinerary Id: {{ itinerary.itineraryId }}</div>
      <div class="itinerary-name">
        Itinerary Name: {{ itinerary.itineraryName }}
      </div>
      <div class="info-item">
        Starting Location (Address) {{ itinerary.startingLocation }}
      </div>
    </div>

    <div class="my-itinerary-landmarks"></div>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService.js";
export default {
  name: "my-itinerary",
  components: {},
  data() {
    return {
      addedLandmarkIds: [],
    };
  },
  computed: {
    itinerary() {
      return this.$store.getters.itinerary;
    },
    methods: {
      addLandmark(landmarkId) {
        if (!this.addedLandmarkIds.includes(landmarkId)) {
          this.addedLandmarkIds.push(landmarkId);

          this.$router.replace({
            name: "myitineraries",
            params: { id: this.itinerary.itineraryId },
          });
        }
      },
      removeLandmark(landmarkId) {
        const index = this.addedLandmarkIds.indexOf(landmarkId);
        if (index !== -1) {
          this.addedLandmarkIds.splice(index, 1);
         
          this.$router.replace({
            name: "myitineraries",
            params: { id: this.itinerary.itineraryId },
          });
        }
      },
    },
  },
  created() {
    const selectedItineraryId = this.$route.params.id;
    console.log(selectedItineraryId);
    ItineraryService.getMyItinerary(selectedItineraryId)
      .then((response) => {
        if (response.status === 200) {
          if (response.data) {
            this.$store.commit("ADD_ITINERARY", response.data);
            // this.itinerary = response.data;
            console.log(this.itinerary);
          } else {
            console.error(
              "Response data is missing 'id' property:",
              response.data
            );
          }
        } else {
          console.error("Unexpected status code:", response.status);
        }
      })
      .catch((err) => console.error("API Error:", err));
  },
};
</script>

<style>
#my-itineraries-button {
  text-align: center;
}

.return-to-itineraries-header {
  font-size: 20px;
}

.return-to-itineraries-header:hover {
  color: darksalmon;
}

.my-itinerary-header {
  color: white;
  text-align: center;
  font-size: 75px;
}

#my-itinerary {
  padding: 20px;
  border: 2px solid;
  background-color: #519bcb;
  border-radius: 30px;
  width: 75%; /* Remove width property */
  margin: 0 auto;
}

.itinerary-name {
  font-weight: bold;
  font-size: 20px;
  color: white;
  text-align: center;
}

.info-item {
  color: white;
  font-size: 15px;
  text-align: center;
  padding: 15px;
}
</style>