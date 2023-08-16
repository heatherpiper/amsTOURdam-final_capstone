<template>
  <div id="map-view-container">
    <div id="map-container">
      <DirectionsMapCompVue />
      <OriginDestinationFormVue />
      <RouteListVue />
    </div>
  </div>
</template>

<script>
import DirectionsMapCompVue from "../components/TrialMap/DirectionsMapComp.vue";
import OriginDestinationFormVue from "../components/TrialMap/OriginDestinationForm.vue";
import RouteListVue from "../components/TrialMap/RouteList.vue";

export default {
  components: {
    DirectionsMapCompVue,
    OriginDestinationFormVue,
    RouteListVue,
  },
};
</script>

<style scoped>

#map-view-container {
  position: relative; 
  height: 100vh;
}

#map-container {
  /* position: relative;  */
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
}

</style>