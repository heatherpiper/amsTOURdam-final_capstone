<template>
  <div>
    <div>
      <h2>Locations Of Interest:</h2>
    </div>
    <br>
    <GmapMap
      :center='center'
      :zoom='12'
      style='width: 400px;  height: 400px;'
    >
      <GmapMarker
        :key="index"
        v-for="(m, index) in markers"
        :position="m.position"
        @click="center=m.position"
      />
    </GmapMap>
    <br>
    <div>
      <GmapAutocomplete
        @place_changed='setPlace'
      />
      <button
        @click='addMarker'
      >
        Pin A New Location
      </button>
    </div>
  </div>
</template>


<script>
export default {
  name: 'GoogleMap',
  data() {
    return {
      center: { lat: 52.377956, lng: 4.89707 },
      currentPlace: null,
      markers: [],
      places: [],
      prePinnedLocations: [
        { lat: 52.376400, lng: 4.887370 },
        { lat: 52.37444444444444, lng: 4.884861111111111 },
        { lat: 52.37516, lng: 4.88398 },
        { lat: 52.373989, lng: 4.912080 },
        { lat: 52.357920, lng: 4.881320 },
        { lat: 52.362540, lng: 4.922240 },
        { lat: 52.366820, lng: 4.926180 },
        { lat: 52.341320, lng: 4.889980 }
      ],
    };
  },
  mounted() {
    this.geolocate();
    this.addPrePinnedMarkers();
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
    geolocate: function() {
      navigator.geolocation.getCurrentPosition(position => {
        this.center = {
          lat: position.coords.latitude,
          lng: position.coords.longitude,
        };
      });
    },
    addPrePinnedMarkers() {
      this.prePinnedLocations.forEach(location => {
        this.markers.push({ position: location });
      });
    },
  },
};
</script>




<style>
</style>
