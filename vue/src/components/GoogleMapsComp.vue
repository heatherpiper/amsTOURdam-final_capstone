<template>
<div>
  <div id="map-container">
    <div class="map-content">
      <!-- <div class="locations-of-interest" v-if="showLocationsOfInterestHeader">
        <h2>Locations of Interest:</h2>
      </div> -->
      <div class="locations-of-interest" v-if="showMyItinerariesLandmarks">
        <h2>Locations on My Itinerary:</h2>
      </div>

      <div class="map-container">
        <GmapMap :center="center" :zoom="13" style="width: 475px; height: 375px">
          <GmapMarker
            :key="index"
            v-for="(m, index) in markers"
            :position="m.position"
            @click="center = m.position"
          />
        </GmapMap>

      </div>
      <br />
      <div class="pin-location-container">
        <GmapAutocomplete @place_changed="setPlace" class="autocompletebox" />
        <button @click="addMarker" class="pin-button">Pin a new location</button>
      </div>
    </div>
  </div>
</div>
</template>


<script>
export default {
  name: "GoogleMap",
  props: ["landmarks"],
  data() {
    return {
      center: { lat: 52.377956, lng: 4.89707 },
      currentPlace: "",
      markers: [],
      places: [],
    };
  },
  computed: {
     showLocationsOfInterestHeader() {
      return this.$route.name === 'landmarks';
    },
    showMyItinerariesLandmarks() {
      return this.$route.name === 'myitinerary';
    }
  },
  mounted() {
    this.geolocate();
  },
  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        let marker = {
          lat: this.currentPlace.geometry.location.lat(),
          lng: this.currentPlace.geometry.location.lng(),
        };
        this.markers.push({ position: marker });
        this.places.push(this.currentPlace);
        this.center = marker;
        this.currentPlace = null;
      }
    },
    geolocate: function () {
      navigator.geolocation.getCurrentPosition((position) => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    locatorButtonPressed() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          (position) => {
            console.log(position.coords.latitude);
            console.log(position.coords.longitude);
          },
          (error) => {
            console.log(error.message);
          }
        );
      } else {
        console.log("Your browser does not support geolocation API ");
      }
    },
    createMarkersFromLandmarks() {
      this.markers = [];
      this.landmarks.forEach((landmark) => {
        const location = {
          lat: landmark.coordinates.latitude,
          lng: landmark.coordinates.longitude,
        };
        this.markers.push({ position: location });
      });
    },
  },
  created() {
    this.createMarkersFromLandmarks();
  },
};
</script>

<style scoped>
#map-container {
  display: flex;
  justify-content: center;
  align-items: center;
  min-height: 70vh;
  background-color: rgba(13, 13, 17, 0.667);
  padding: 15px;
  margin: 20px 10vw;
  border-radius: 25px;
}

h2 {
  font-size: 35px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

div.locations-of-interest {
  text-align: center;
  color:#2ac1d7;
}

.autocompletebox {
  font-size: 16px;
  border-radius: 20px;
  line-height: 40px;
  padding-left: 5px;
}

button.pin-button {
  color: black;
  background-color: #2ac1d7;
  margin: 10px;
  padding: 10px;
  font-size: 20px;
  border-radius: 20px;
  font-weight: bold;
  line-height: 30px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

button.pin-button:hover {
  background-color: darksalmon;
  cursor: pointer;
}

</style>

