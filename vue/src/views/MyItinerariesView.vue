<template>
  <div>
    <MyItinerariesComp />
    <br>
    <CreateItineraryComp />
    <br>
    <!-- <EditItineraryCompVue /> -->
  </div>
</template>

<script>
import MyItinerariesComp from '../components/MyItinerariesComp.vue';
import CreateItineraryComp from "../components/CreateItineraryComp.vue";
//import EditItineraryCompVue from '../components/EditItineraryComp.vue';



export default {
    components: {
        CreateItineraryComp,
        MyItinerariesComp,
       // EditItineraryCompVue
    }
}
</script>

<style>

</style>