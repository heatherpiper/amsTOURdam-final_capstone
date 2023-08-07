<template>
  <div class="add-landmarks">
      
  </div>
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
              name: '/landmarks/add-landmark', 
             // params: { id: productID }
            });
          }
        })
        .catch( err => console.error(err) );
    },
   // resetForm() {
     // this.newLandmark = {};
   // }
        }
};
</script>

<style>
h1 {
  text-align: center;
  font-family: arial Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>