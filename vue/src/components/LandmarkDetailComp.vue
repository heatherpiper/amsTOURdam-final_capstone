<template>
  <div class="landmark">
      <h2 class="landmark-name">{{ landmark.name }}</h2>
      <div class="img">
      
       <img class="landmark-image" v-bind:src="landmark.imageName">
      </div>
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
    background-color: white;
    text-align: center;
    width: 700px;
    margin: 0 auto;
    border: 10px solid #519bcb;
    color: #519bcb;
    font-family: Georgia, 'Times New Roman', Times, serif;
    border-radius: 20px
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  width: 500px;
}

</style>