<template>
<div class="addlandmarks">
<h1> Add New Landmark</h1>
<form id="form" v-on:submit.prevent="addNewLandmark">
  <div class="form-element">
      <label for="category">Category:</label>
      <input id="category" type="text" v-model="newLandmark.category" />
  </div>
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
      <input id="houseNumber" type="text" v-model="newLandmark.address.houseNumber" />
  </div>
  <div class="form-element">
      <label for="postalCode">Postal Code:</label>
      <input id="postalCode" type="text" v-model="newLandmark.address.postalCode" />
  </div>
  <div class="form-element">
      <label for="city">City:</label>
      <input id="city" type="text" v-model="newLandmark.address.city" />
  </div>
  <div class="form-element">
      <label for="country">Country:</label>
      <input id="country" type="text" v-model="newLandmark.address.country" />
  </div>
  <div class="form-element">
      <label for="latitudeCoordinates">Latitude Coordinates:</label>
      <input id="latitudeCoordinates" type="text" v-model.number="newLandmark.coordinates.latitude" />
  </div>
  <div class="form-element">
      <label for="longitudeCoordinates">Longitude Coordinates:</label>
      <input id="longitudeCoordinates" type="text" v-model.number="newLandmark.coordinates.longitude" />
  </div>
  <div class="form-element">
      <label for="imageName">Image Name:</label>
      <input id="imageName" type="url" v-model="newLandmark.imageName" />
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
      <label for="duration">Duration:</label>
      <input id="duration" type="text" v-model="newLandmark.duration" />
  </div>
  <div class="form-element">
      <label for="reviews">Reviews:</label>
      <input id="reviews" type="text" v-model="newLandmark.reviews" />
  </div>
  <div class="actions">
      <button v-on:click="resetForm()" type="button" class="cancel-button">Cancel</button>
      <button class="submit-button">Submit</button>
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
          category: "",
          name: "",
          address: {
          street: "",
          houseNumber: "",
          postalCode: "",
          city: "",
          country: "",
        },
        coordinates: {
          latitude: "",
          longitude: "",
        },
        imageName: "",
        description: "",
        historicDetails: "",
        costOfEntry: "",
        duration: "",
        reviews: "",
      },
      formError: false,
      formErrorMessage: "There was a problem with your submission. Please try again."
    };
  },
  methods: {
    addNewLandmark() {
      LandmarksService.addLandmark(this.newLandmark)
        .then((response) => {
          if (response.status === 201) {
            this.$router.push({
              name: "landmarks",
            });
          }
        })
        .catch((err) => {
          const response = err.response;
          this.formError = true;
          if(response.status === 500){
            this.formErrorMessage = "Server Error:" + response.message;
            alert(this.formErrorMessage);
          } else
          alert(this.formErrorMessage);
          
        });
    },
    resetForm() {
      this.newLandmark = {
          landmarkId: "",
          category: "",
          name: "",
          address: {
            street: "",
            houseNumber: "",
            postalCode: "",
            city: "",
            country: "",
        },
        coordinates: {
          latitude: "",
          longitude: "",
        },
        imageName: "",
        description: "",
        historicDetails: "",
        costOfEntry: "",
        duration: "",
        reviews: "",
      };
    },
  },
};
</script>

<style scoped>

h1 {
  text-align: center;
  font-size: 60px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
  width: 100vw;
}

input {
  border-radius: 15px;
}

.addlandmarks {
    display: flex;
    align-items: center;
    flex-direction: column;
}
#form {
width: 50vw;
margin-top: 50px;
background-color:rgba(13, 13, 17, 0.667);
border-radius: 15px;
}
.form-element {
display: flex;
margin-top: 10px;
margin-bottom: 5px;
height: 2.50vw;
font-family: 'Bricolage Grotesque', sans-serif;
text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
color: var(--accent-color-light);
}
.actions {
    display: block;
    text-align: center;
    margin: 20px;
    padding: 10px;
    align-items:center;
    
}
.form-element label {
    font-weight: bolder;
    align-content: right;
    justify-content: right;
    vertical-align: right;
    font-size: 25px;
    padding: 20px;
    width: 500px;
}
.form-element textarea {
    display: block;
    align-content: center;
    text-align: center;
    justify-content: space-between;
    
}
.form-element label,
textarea {
  font-weight: bold;
  padding: 20px;
  width: 500px;
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
h2 {
  text-align: center;
}

.cancel-button {
  border-radius: 15px;
  color: white;
  background-color: rgba(13, 13, 17, 0.667);
  padding: 6px;
  font-family: 'Bricolage Grotesque', sans-serif;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.cancel-button:hover {
  cursor: pointer;
  color: darksalmon;
}

.submit-button {
  border-radius: 15px;
  color: white;
  background-color: rgba(13, 13, 17, 0.667);
  padding: 6px;
  font-family: 'Bricolage Grotesque', sans-serif;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
}

.submit-button:hover {
   cursor: pointer;
  color: darksalmon;
}

</style>