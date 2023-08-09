<template>
  <div>
    <form v-on:submit.prevent="addNewLandmark">
      <h1>Add New Landmark</h1>
      <div class="form-element">
        <label for="name">Name:</label>
        <input id="name" type="text" v-model="newLandmark.name" />
      </div>
      <div class="form-element">
        <label for="street">Street:</label>
        <input id="street" type="text" v-model="newLandmark.address.street" />
      </div>
      <div class="form-element">
        <label for="houseNumber">House Number:</label>
        <input
          id="houseNumber"
          type="text"
          v-model.number="newLandmark.address.houseNumber"
        />
      </div>
      <div class="form-element">
        <label for="postalCode">Postal Code:</label>
        <input
          id="postalCode"
          type="text"
          v-model.number="newLandmark.address.postalCode"
        />
      </div>
      <div class="form-element">
        <label for="city">City:</label>
        <input id="city" type="text" v-model="newLandmark.address.city" />
      </div>
      <div class="form-element">
        <label for="town">Town:</label>
        <input id="town" type="text" v-model="newLandmark.address.town" />
      </div>
      <div class="form-element">
        <label for="latitudeCoordinates">Latitude Coordinates:</label>
        <input
          id="latitudeCoordinates"
          type="text"
          v-model.number="newLandmark.coordinates.latitude"
        />
      </div>
      <div class="form-element">
        <label for="longitudeCoordinates">Longitude Coordinates:</label>
        <input
          id="longitudeCoordinates"
          type="text"
          v-model.number="newLandmark.coordinates.longitude"
        />
      </div>
      <div class="form-element">
        <label for="imageName">Image Name:</label>
        <input id="imageName" type="text" v-model="newLandmark.imageName" />
      </div>
      <div class="form-element">
        <label for="description">Description:</label>
        <input id="description" type="text" v-model="newLandmark.description" />
      </div>
      <div class="form-element">
        <label for="historicDetails">Historic Details:</label>
        <input
          id="historicDetails"
          type="text"
          v-model="newLandmark.historicDetails"
        />
      </div>
      <div class="form-element">
        <label for="costOfEntry">Cost Of Entry:</label>
        <input id="costOfEntry" type="text" v-model="newLandmark.costOfEntry" />
      </div>
      <div class="form-element">
        <label for="reviews">Reviews:</label>
        <input id="reviews" type="text" v-model="newLandmark.reviews" />
      </div>
      <div class="actions">
        <button v-on:click="resetForm()" type="button">Cancel</button>
        <button>Submit</button>
      </div>
    </form>
  </div>
</template>

<script>
import LandmarksService from "../services/LandmarksService";

export default {
  name: "add-landmark",
  data() {
    return {
      newLandmark: {
        landmarkId: "",
        name: "",
        address: {
          street: "",
          houseNumber: "",
          postalCode: "",
          city: "",
          town: "",
        },
        coordinates: {
          latitude: "",
          longitude: "",
        },
        imageName: "",
        description: "",
        historicDetails: "",
        costOfEntry: "",
        reviews: "",
      },
    };
  },
  methods: {
    addNewLandmark() {
      console.log(this.newLandmark);
      LandmarksService.addLandmark(this.newLandmark)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push({
              name: "landmarks",
            });
          }
        })
        .catch((err) => console.error(err));
    },
    resetForm() {
      this.newLandmark = {
        landmarkId: "",
        name: "",
        address: {
          street: "",
          houseNumber: "",
          postalCode: "",
          city: "",
          town: "",
        },
        coordinates: {
          latitude: "",
          longitude: "",
        },
        imageName: "",
        description: "",
        historicDetails: "",
        costOfEntry: "",
        reviews: "",
      };
    },
  },
};
</script>

<style>
#form {
  align-content: center;
  top: auto;
  right: auto;
  bottom: auto;
  left: auto;
}
.form-element label,
textarea {
  font-weight: bold;
  padding: 20px;
  width: 500px;
  height: 500px;
}
.form-element textarea {
  display: flex;
  align-content: center;
  justify-content: center;
  padding: 100px;
}
.actions {
  vertical-align: auto;
  margin: 20px;
  padding: 10px;
  align-items: center;
}
</style>