<template>
<div>
  <div>
    <h1>Create a Route:</h1>
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
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
}


</style>