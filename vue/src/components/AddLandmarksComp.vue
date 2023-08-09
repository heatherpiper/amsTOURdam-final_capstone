<template>
<div class="addlandmarks">
<h1> Add New Landmark</h1>
<form id="form" v-on:submit.prevent="addNewLandmark">
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
      <input id="houseNumber" type="text" v-model.number="newLandmark.address.houseNumber" />
  </div>
  <div class="form-element">
      <label for="postalCode">Postal Code:</label>
      <input id="postalCode" type="text" v-model.number="newLandmark.address.postalCode" />
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
      <input id="latitudeCoordinates" type="text" v-model.number="newLandmark.coordinates.latitude" />
  </div>
  <div class="form-element">
      <label for="longitudeCoordinates">Longitude Coordinates:</label>
      <input id="longitudeCoordinates" type="text" v-model.number="newLandmark.coordinates.longitude" />
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
      <button v-on:click="resetForm()" type="button">Cancel</button>
      <button>Submit</button>
    </div>
  </form>
  </div>
</template>

<script>
import LandmarksService from '../services/LandmarksService';

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
                    reviews: ""
            }
        };
        },
        methods: {
            addNewLandmark() {
                console.log(this.newLandmark)
            LandmarksService.addLandmark(this.newLandmark)
        .then( response => {
          if (response.status === 201) {
            this.$router.push( { 
 
              name: 'landmarks',  

            });
          }
        })
        .catch( err => console.error(err) );
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
                    reviews: ""
      };
    }
        }
};
</script>

<style>
.addlandmarks {
    display: flex;
    align-items: center;
    flex-direction: column;
}
#form {
width: 50vw;
margin-top: 50px;
background-color:aliceblue;
}
.form-element {
display: flex;
margin-top: 10px;
margin-bottom: 5px;
height: 2.50vw;
}
.actions {
    display: block;
    text-align: center;
    margin: 20px;
    padding: 10px;
    align-items:center;
    
}
div.addlandmarks h1 {
  text-align: center;
  font-size: 60px;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, 'Times New Roman', Times, serif;
  background-color: rgb(231, 163, 17);
  width: 900px;
  margin: 0 auto;
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

</style>