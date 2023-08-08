<template>
  <div id="landmarks">
    
    <div class="LandmarksList" v-for="landmark in landmarks" v-bind:key="landmark.landmark_id">
      <router-link v-bind:to="{
        name:'landmarkdetail', 
        params:{ id: landmark.landmark_id } }">
        <h1>{{ landmark.name }}</h1>
      </router-link>
        <h2>{{ landmark.description}}</h2>
      <!-- <landmark-detail v-for="landmark in landmarks" v-bind:key="landmark.landmarkId" v-bind:landmark="landmarks"/> -->
    </div>
  </div>
</template>

<script>
// import LandmarkDetail from './LandmarkDetailComp.vue'

export default {
name: "landmarks",
components: {
  // LandmarkDetail
},
props: ['landmarks']
}
</script>

<style>

</style>