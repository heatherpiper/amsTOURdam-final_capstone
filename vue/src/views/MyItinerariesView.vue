<template>
  <div>
    <MyItinerariesComp />
    <br>
    <br>
    <CreateItineraryComp />
    <br>
   
  </div>
</template>

<script>
import MyItinerariesComp from '../components/MyItinerariesComp.vue';
import CreateItineraryComp from "../components/CreateItineraryComp.vue";



export default {
    components: {
        CreateItineraryComp,
        MyItinerariesComp,
       
    }
}
</script>

<style>

</style>