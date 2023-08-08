<template>
  <div id="landmarks">
    
    <div class="LandmarksList" v-for="landmark in landmarks" v-bind:key="landmark.id">
      <router-link v-bind:to="{name: 'landmark'}">
        <h1>{{ landmark.name }}</h1>
        <p>{{ landmark.description}}</p>
      </router-link>
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