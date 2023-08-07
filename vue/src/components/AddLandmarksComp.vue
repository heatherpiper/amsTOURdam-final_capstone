<template>
  <div>

  </div>
</template>

<script>
import LandmarksService from '../services/LandmarksService';

export default {
    name: "add-landmark",
    data() {
        return {
            newLandmark: {
                name: "",
                address: "",
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