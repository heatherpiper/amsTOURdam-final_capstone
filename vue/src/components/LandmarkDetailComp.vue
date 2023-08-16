<template>
  <div class="landmark">
    <slot />
    <h2 class="landmark-name">{{ landmark.name }}</h2>
    <div class="img">
      <img class="landmark-image" v-bind:src="landmark.imageName" />
    </div>
    <h3 class="address">
      Address: {{ landmark.address?.street }}
      {{ landmark.address?.houseNumber }} {{ landmark.address?.postalCode }}
      {{ landmark.address?.city }} {{ landmark.address?.town }}
    </h3>
    <h3 class="description">Description: {{ landmark.description }}</h3>
    <h3 class="historic-details">
      Historic Details: {{ landmark.historicDetails }}
    </h3>
    <h3 class="cost">Cost of Entry: {{ landmark.costOfEntry }}</h3>
    <h3 class="reviews">Reviews: {{ landmark.reviews }}</h3>
    <div class="button-container">
        <router-link style="text-decoration: none;" class="navlink" @click.prevent.stop v-bind:to="{ name: 'landmarks' }">
          <div>
            <h2>Check Out More Landmarks</h2>
          </div>
        </router-link>
        <router-link style="text-decoration: none;" class="navlink" @click.prevent.stop v-bind:to="{ name: 'myitineraries' }">
          <h2>Make an Itinerary</h2>
        </router-link>
      </div>
  </div>
</template>


<script>
import LandmarksService from "../services/LandmarksService";

export default {
  name: "landmark-detail",
  props: ["landmarks"],
  data() {
    return {
      landmarkId: 0,
      landmark: {},
    };
  },
  created() {
    this.landmarkId = this.$route.params.id;
    LandmarksService.getLandmarkById(this.landmarkId).then((response) => {
      this.landmark = response.data;
    });
  },
  methods: {},
};
</script>

<style>

div.landmark {
    background-color: white;
    text-align: center;
    width: 700px;
    margin: 0 auto;
    border: 2px solid #298a91;
    border-radius: 20px;
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  width: 500px;
}

.button-container {
  display: flex;
  justify-content: space-evenly;
  margin: 10px;
}

.navlink h2 {
  font-size: 20px;
  border: 10px solid  #298a91;
  background-color: #298a91;
  border-radius: 45px;
  color: white;
  text-decoration: none;
}

.navlink h2:hover {
  color: darksalmon;
  text-decoration: none;
}

router-link {
    text-decoration: none;
}

</style>