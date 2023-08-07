<template>
  <div>

  </div>
</template>

<script>
import LandmarksService from '../services/LandmarksService'

export default {
name: "landmarks",
data() {
    return {
        landmarks: []
    }
},
 created() {
        LandmarksService.getAllLandmarks().then( response => {
        this.landmarks = response.data;
        })
    }
}
</script>

<style>

</style>