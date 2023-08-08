<template>
  <div class="landmark">
      <h2 class="landmark-name">{{ landmark.name }}</h2>
      <h3 class="street">{{ landmark.address.street }}</h3>
      <h3 class="house-number">{{ landmark.address.houseNumber }}</h3>
      <h3 class="postal-code">{{ landmark.address.postalCode }}</h3>
      <h3 class="city">{{ landmark.address.city }}</h3>
      <h3 class="town">{{ landmark.address.town }}</h3>
      <h3 class="latitude">{{ landmark.coordinates.latitudeCoordinates }}</h3>
      <h3 class="longitude">{{ landmark.coordinates.longitudeCoordinates }}</h3>
      <h3 class="image-name">{{ landmark.imageName }}</h3>
      <h3 class="description">{{ landmark.description }}</h3>
      <h3 class="historic-details">{{ landmark.historicDetails }}</h3>
      <h3 class= "cost">{{ landmark.costOfEntry }}</h3>
      <h3 class="reviews">{{ landmark.reviews }}</h3>
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