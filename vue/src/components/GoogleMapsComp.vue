<template>
  <div>
    <div class="locationsofinterest">
      <h2>Locations Of Interest:</h2>
    </div>
    <br />

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
      <button @click="addMarker" class="pin-button">Pin A New Location</button>
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
      places: []
    };
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
div.locationsofinterest {
  text-align: center;
  border: 1px solid rgb(231, 163, 17);
  color: rgb(231, 163, 17);
  font-family: Georgia, "Times New Roman", Times, serif;
  background-color: rgb(102, 3, 89);
  border-radius: 10px;
  font-size: 20px;

  line-height: 1px;
}

div.map-container {
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, "Times New Roman", Times, serif;
  background-color: rgb(231, 163, 17);
  border-radius: 5px;
}

.autocompletebox {
  font-size: 16px;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  border-radius: 20px;
  color: rgb(102, 3, 89);
  background-color: rgb(231, 163, 17);
  line-height: 40px;
}

button.pin-button {
  border: 3px solid rgb(231, 163, 17);
  color: rgb(231, 163, 17);
  font-family: Georgia, "Times New Roman", Times, serif;
  background-color: rgb(102, 3, 89);
  margin: 20px;
  font-size: 20px;
  border-radius: 20px;
  font-weight: bold;

  line-height: 30px;
}

button.pin-button:hover {
  background-color: rgb(91, 47, 109);
}
</style>

