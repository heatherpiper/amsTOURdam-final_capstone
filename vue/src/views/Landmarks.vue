<template>
  <div class="landmarks">
    <LandmarksComp />
    <h1>Landmarks</h1>

  </div>
</template>

<script>

import LandmarksComp from '../components/LandmarksComp.vue'

export default {
    components: {
        LandmarksComp,
    }
}
</script>

<style>
h1 {
  text-align: center;
  font-family: arial Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}

</style>