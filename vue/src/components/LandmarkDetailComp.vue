<template>
  <div class="landmark">
    <slot />
    <h2 class="landmark-name">{{ landmark.name }}</h2>
    <div class="img">
      <img class="landmark-image" v-bind:src="landmark.imageName" />
    </div>
    <br>
    <div class="upload-photos-button">
      <ImageUploadComp />
    </div>
    <br>
    <h3 class="address">
      Address: {{ landmark.address?.street }}
      {{ landmark.address?.houseNumber }} {{ landmark.address?.postalCode }}
      {{ landmark.address?.city }} {{ landmark.address?.town }}
    </h3>
    <h3 class="description">Description: {{ landmark.description }}</h3>
    <h3 class="historic-details">
      Historic Details: {{ landmark.historicDetails }}
    </h3>
    <h3 class="cost">Cost of Entry: {{ landmark.costOfEntry }} Euros</h3>
    <br>
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
import ImageUploadComp from './ImageUploadComp.vue';  

export default {
  name: "landmark-detail",
  props: ["landmarks"],
  components: {
    ImageUploadComp
  },
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

<style scoped>

div.landmark {
    background-color: white;
    text-align: center;
    width: 700px;
    margin: 10px auto;
    border: 2px solid #2ac1d7;
    border-radius: 20px;
}

.landmark-name {
  color: #4183c4;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  font-size: 45px;
}

img.landmark-image {
  display: block;
  margin: 0 auto;
  width: 500px;
}

h3 {
  font-family: 'Bricolage Grotesque', sans-serif;
  margin: 10px 20px;
  text-align: left;
  color: rgba(13, 13, 17, 0.667);

}

h3.address {
  text-align: center;
}

h3.cost {
  text-align: center;
}

.button-container {
  display: flex;
  justify-content: space-evenly;
  margin: 10px;
}

.navlink h2 {
  font-size: 20px;
  border: 10px solid  #2ac1d7;
  background-color: #2ac1d7;
  border-radius: 45px;
  color: white;
  text-decoration: none;
}

.navlink h2:hover {
  color: #FDE75D;
  text-decoration: none;
}

router-link {
  text-decoration: none;
}

</style>