<template>
  <div class="landmark">
      <h2>{{ landmark.name }}</h2>
      <p>{{ landmark.address.street }}</p>
  </div>
</template>

<script>
import LandmarksService from '../services/LandmarksService';

export default {
    name: "landmark-detail",
    data() {
        return {
            landmarkId: 0,
            landmark: {}
        }
    },
    created() {
        this.landmarkId = this.$route.params.id;
        LandmarksService.getLandmarkById(this.landmarkId).then(response => {
            this.landmark = response.data;
        });
    }


}
</script>

<style>

</style>