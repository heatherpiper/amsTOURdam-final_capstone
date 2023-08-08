<template>
  <div>
    <div>
      <h2>Search and add a pin</h2>
      <GmapAutocomplete @place_changed="setPlace" />
      <button @click="addMarker">Add</button>
    </div>
    <div>
      <button @click="searchNearbyPlaces">Search Nearby Locations</button>
    </div>
    <br />
    <GmapMap :center="center" :zoom="12" style="width: 400px; height: 400px">
      <GmapMarker
        ref="map"
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center = m.position"
      />
    </GmapMap>
  </div>
</template>

<script>
export default {
  name: "GoogleMap",
  data() {
    return {
      center: { lat: 52.377956, lng: 4.89707 },
      currentPlace: null,
      markers: [],
      places: [],
      service: null,
    };
  },
  mounted() {
    this.geolocate();

    if (this.$refs.map) {
      this.service = new window.google.maps.places.PlacesService(
        this.$refs.map.$mapObject
      );
    }

    this.handleNearbySearchResults = this.handleNearbySearchResults.bind(this);
  },
  methods: {
    setPlace(place) {
      this.currentPlace = place;
    },
    addMarker() {
      if (this.currentPlace) {
        const marker = {
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
    searchNearbyPlaces() {
      if (this.center && this.service) {
        const request = {
          location: this.center,
          radius: 1000,
          type: 'restaurant'
        };

        this.service.nearbySearch(request, this.handleNearbySearchResults);
      }
    },

    handleNearbySearchResults(results, status) {
  if (status === window.google.maps.places.PlacesServiceStatus.OK) {
    this.markers = [];

    results.forEach((result) => {
      const marker = {
        lat: result.geometry.location.lat(),
        lng: result.geometry.location.lng(),
      };
      this.markers.push({ position: marker });
    });

    if (results.length > 0) {
      const firstPlace = results[0];
      this.center = {
        lat: firstPlace.geometry.location.lat(),
        lng: firstPlace.geometry.location.lng(),
      };
    }
  }
},
  },
};
</script>

<style>
</style>