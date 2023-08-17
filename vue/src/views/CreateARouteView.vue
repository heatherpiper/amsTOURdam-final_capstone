<template>
<div>
  <div>
    <h1>Map Your Way Through Amsterdam:</h1>
  </div>
  <div id="map-view-container">
    <div id="map-container">
      <DirectionsMapCompVue />
      <OriginDestinationFormVue />
      <RouteListVue />
    </div>
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

h1 {
  text-align: center;
  font-size: 60px;
  border-bottom: 2px solid;
  border-top: 2px solid;
  margin: 0 auto;
  color: #2ac1d7;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}



</style>