<template>
  <div id="create-itinerary">
    <div v-show="!showForm">
            <a href="#" v-on:click.prevent="showForm = true">
              <h1>Create an Itinerary:</h1>
            </a>
        </div>
    <br />
    <form id="itinerary" v-on:submit.prevent="createItinerary()" v-if="showForm">
      <div class="input-name">
        <label for="name">Itinerary Name:</label>
        <input id="name" type="text" v-model="createdItinerary.itineraryName" />
      </div>
      <div class="input-starting-location">
        <label for="name">Starting Location (Address):</label>
        <input
          id="starting-location"
          type="text"
          v-model="createdItinerary.startingLocation"
        />
      </div>

       <div class="input-latitude">
        <label for="latitudeInput">Latitude Coordinates:</label>
        <input
          type="number" step="0.000001" min="-90" max="90" name="latitudeInput" id="latitudeInput"
          v-model="createdItinerary.latitude"
        />
      </div>

        <div class="input-longitude">
        <label for="longitudeInput">Longitude Coordinates:</label>
        <input
           type="number" step="0.000001" min="-90" max="90" name="longitudeInput" id="longitudeInput"
          v-model="createdItinerary.longitude"
        />
      </div>

      <div class="create-buttons">
        <input v-on:click.prevent="hideForm" type="button" value="Cancel"  />
        <input v-on:click.prevent="resetForm()" type="button" value="Reset Form" />
        <input type="submit" value="Submit Form" v-bind:disabled="!isFormValid" />
      </div>
    </form>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";

export default {
  name: "create-itinerary",
  data() {
    return {
      showForm: false,
      createdItinerary: {
        itineraryId: "",
        itineraryName: "",
        startingLocation: "",
        latitude: "",
        longitude: "",
      },
    };
  },
   computed: {
        isFormValid() {
           return this.createdItinerary.itineraryName 
           && this.createdItinerary.startingLocation   
        }
    },
  methods: {
    createItinerary() {
      this.createdItinerary.userId = this.$store.state.user.id;
      console.log(this.createdItinerary.userId);
      ItineraryService.createItinerary(this.createdItinerary)
        .then((response) => {
          if (response.status === 201) {
            if (response.data && response.data.itineraryId) {
              this.createdItinerary = response.data;
              this.$store.commit("ADD_ITINERARY", this.createdItinerary);
              console.log(this.createdItinerary);
              console.log(this.$store.state.user.itinerary);
              this.$router.push({
                name: "myitinerary",
                params: { id: this.createdItinerary.itineraryId },
              });
              this.resetForm();
            } else {
              console.error("Response data is missing 'id' property:", response.data);
            }
          } else {
            console.error("Unexpected status code:", response.status);
          }
        })
        .catch((err) => console.error("API Error:", err));
    },
    resetForm() {
      this.createdItinerary = {
        itineraryId: "",
        itineraryName: "",
        startingLocation: "",
        latitude: "",
        longitude: "",
      };
    },
    hideForm() {
    this.showForm = false;
    this.resetForm(); 
  }
  },
};
</script>

<style scoped>
h1 {
  font-size: 40px;
}

#create-itinerary {
  background-color: rgb(231, 163, 17);
  text-align: center;
  width: 700px;
  margin: 0 auto;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, "Times New Roman", Times, serif;
  border-radius: 10px;
}

.input-name {
  font-size: 30px;
}

.input-starting-location {
  font-size: 30px;
}

label {
  padding: 20px;
}
</style>