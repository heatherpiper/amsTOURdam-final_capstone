<template>
  <div>

  </div>
</template>

<script>
//import LandmarksService from '../services/LandmarksService';

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
        }
    }
};
</script>

<style>

</style>