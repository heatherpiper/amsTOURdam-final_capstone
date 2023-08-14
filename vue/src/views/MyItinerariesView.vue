<template>
  <div>
    <MyItinerariesComp />
    <br>
    <EditItineraryComp />
    <br>
    <CreateItineraryComp />
  </div>
</template>

<script>
import MyItinerariesComp from '../components/MyItinerariesComp.vue';
import CreateItineraryComp from "../components/CreateItineraryComp.vue";
import EditItineraryComp from "../components/EditItineraryComp.vue";


export default {
    components: {
        CreateItineraryComp,
        MyItinerariesComp,
        EditItineraryComp,
    }
}
</script>

<style>

</style>