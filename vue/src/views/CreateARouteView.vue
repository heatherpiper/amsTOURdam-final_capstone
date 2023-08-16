<template>
  <div>
    <DirectionsMapCompVue />
    <OriginDestinationFormVue />
    <RouteListVue />
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

<style>
</style>