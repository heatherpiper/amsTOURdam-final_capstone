<template>
<form v-on:submit.prevent="addNewLandmark">
  <div class="form-element">
      <label for="name">Name:</label>
      <input id="name" type="text" v-model="newLandmark.name" />
  </div>
  <div class="form-element">
      <label for="street">Street:</label>
      <input id="street" type="text" v-model="newLandmark.street" />
  </div>
  <div class="form-element">
      <label for="houseNumber">House Number:</label>
      <input id="houseNumber" type="text" v-model="newLandmark.houseNumber" />
  </div>
  <div class="form-element">
      <label for="postalCode">Postal Code:</label>
      <input id="postalCode" type="text" v-model="newLandmark.postalCode" />
  </div>
  <div class="form-element">
      <label for="city">City:</label>
      <input id="city" type="text" v-model="newLandmark.city" />
  </div>
  <div class="form-element">
      <label for="town">Town:</label>
      <input id="town" type="text" v-model="newLandmark.town" />
  </div>
  <div class="form-element">
      <label for="latitudeCoordinates">Latitude Coordinates:</label>
      <input id="latitudeCoordinates" type="text" v-model="newLandmark.latitudeCoordinates" />
  </div>
  <div class="form-element">
      <label for="longitudeCoordinates">Longitude Coordinates:</label>
      <input id="longitudeCoordinates" type="text" v-model="newLandmark.longitudeCoordinates" />
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
      <input id="historicDetails" type="text" v-model="newLandmark.historicDetails" />
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
      <button v-on:click="resetForm" type="button">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
</template>

<script>
import LandmarksService from '../services/LandmarksService';

export default {
    name: "add-landmark",
    data() {
        return {
            newLandmark: {
                    landmarkId: 0,
                    name: "",
                    street: "",
                    houseNumber: 0,
                    postalCode: 0,
                    city: "",
                    town: "",
                    latitudeCoordinates: 0.0,
                    longitudeCoordinates: 0.0,
                    imageName: "",
                    description: "",
                    historicDetails: "",
                    costOfEntry: 0.0,
                    reviews: ""
            }
        };
        },
        methods: {
            addNewLandmark() {
            LandmarksService.addLandmark(this.newLandmark)
        .then( response => {
          if (response.status === 201) {
            this.$router.push( { 
              name: 'add-landmarks', 
             // params: { id: productID }
            });
          }
        })
        .catch( err => console.error(err) );
    },
    resetForm() {
      this.newLandmark = {};
    }
        }
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
padding: 150px;
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
    align-items:center;
}

</style>