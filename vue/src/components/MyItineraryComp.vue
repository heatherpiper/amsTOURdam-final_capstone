<template>
  <div>
    <div>
      <h1 class="my-itinerary-header">My Amsterdam Intinerary:</h1>
    </div>
    <br>
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
      <div class="itinerary-name">
       {{ itinerary.itineraryName }}
      </div>
      <br>
      <div class="info-item">
        Starting Location: {{ itinerary.startingLocation }}
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
          this.refreshPage();
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
      refreshPage(){
        location.reload();
      }
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
  font-family: 'Bricolage Grotesque', sans-serif;
}

.return-to-itineraries-header:hover {
  color: darksalmon;
}

h1.my-itinerary-header {
  text-align: center;
  font-size: 60px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
  font-family: 'Bricolage Grotesque', sans-serif;
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
  font-size: 40px;
  color: white;
  text-align: center;
  font-family: 'Bricolage Grotesque', sans-serif;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.info-item {
  color: white;
  font-size: 20px;
  text-align: center;
  padding: 15px;
  font-family: 'Bricolage Grotesque', sans-serif;
}
</style>