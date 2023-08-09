<template>
  <div class="landmark">
      <h2 class="landmark-name">{{ landmark.name }}</h2>
      <img v-bind:src="require('../media/assets/' + landmark.imageName)" alt="">
      <h3 class="address">Address: {{ landmark.address.street }} {{ landmark.address.houseNumber }} {{ landmark.address.postalCode }} {{ landmark.address.city }} {{ landmark.address.town }}</h3>
      <h3 class="description">Description: {{ landmark.description }}</h3>
      <h3 class="historic-details">Historic Details: {{ landmark.historicDetails }}</h3>
      <h3 class= "cost">Cost of Entry: {{ landmark.costOfEntry }}</h3>
      <h3 class="reviews">Reviews: {{ landmark.reviews }}</h3>
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

<style scoped>

div.landmark {
    background-color: rgb(231, 163, 17);
    text-align: center;
    width: 700px;
    margin: 0 auto;
    border: 10px solid rgb(102, 3, 89);
    border-style: double;
    color: rgb(58, 2, 58);
    font-family: Georgia, 'Times New Roman', Times, serif;
}

</style>