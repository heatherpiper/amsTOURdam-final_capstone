<template>
  <div id="edit-itinerary">
    <div class="edit-form-button" v-show="!showForm">
      <a href="#" v-on:click.prevent="showForm = true">
        <h2>Edit an Itinerary:</h2>
      </a>
    </div>
    <br />

    <form
      id="Edit-itinerary"
      v-on:submit.prevent="updateItinerary()"
      v-if="showForm"
    >
      <div class="input-name">
        <label for="name">Itinerary Name:</label>
        <input id="name" type="text" v-model="editedItinerary.itineraryName" />
      </div>
      <div class="input-starting-location">
        <label for="name">Starting Location (Address):</label>
        <input
          id="starting-location"
          type="text"
          v-model="editedItinerary.startingLocation"
        />
      </div>

      <div class="input-latitude">
        <label for="latitudeInput">Latitude Coordinates:</label>
        <input
          type="number"
          step="0.000001"
          min="-90"
          max="90"
          name="latitudeInput"
          id="latitudeInput"
          v-model="editedItinerary.latitude"
        />
      </div>

      <div class="input-longitude">
        <label for="longitudeInput">Longitude Coordinates:</label>
        <input
          type="number"
          step="0.000001"
          min="-90"
          max="90"
          name="longitudeInput"
          id="longitudeInput"
          v-model="editedItinerary.longitude"
        />
      </div>

      <div class="create-buttons">
        <input v-on:click.prevent="hideForm" type="button" value="Cancel" />
        <input
          v-on:click.prevent="resetForm()"
          type="button"
          value="Reset Form"
        />
        <button type="submit">Update</button>
      </div>
    </form>
  </div>
</template>

<script>
import ItineraryService from "@/services/ItineraryService";

export default {
  name: "edit-itinerary",
  data() {
    return {
      showForm: false,


      editedItinerary: {
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
      return (
        this.editedItinerary.itineraryName &&
        this.editedItinerary.startingLocation
      );
    },
  },

  methods: {
    updateItinerary() {
      this.itineraryId = this.$store.state.itinerary.id;

      ItineraryService.updateItineraryByItineraryId(
        this.itineraryId,
        this.editedItinerary
      )
        .then((response) => {
          if (response.status === 200) {
            if (response.data) {
              this.editedItinerary = response.data;
              // this.$store.commit("UPDATE_ITINERARY", this.editedItinerary);
              //console.log(this.editedItinerary);
              this.$router.push({
                name: "myitinerary",
                params: { id: this.editedItinerary.itineraryId },
              });
              this.resetForm();
            } else {
              console.error(
                "Response data is missing 'id' property:",
                response.data
              );
            }
          } else {
            console.error("Unexpected status code:", response.status);
          }
        })
        .catch((err) => console.error("API Error:", err));
    },
    resetForm() {
      this.editedItinerary = {
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
    },
  },
  getItineraryData: function (itineraryId) {
    ItineraryService.getMyItinerary(itineraryId)
      .then((response) => {
        //console.log(response.data.itinerary);
        this.editedItinerary = response.data.itinerary;
      })
      .catch(function (error) {
        if (error.response) {
          if (error.response.status == 404) {
            alert(error.response.data.message);
          }
        }
      });
  },
  mounted() {
    this.getItineraryData(this.$route.params.id);
    //console.log(this.$route.params.itineraryId);
  },
};
</script>

<style scoped>
form {
  text-align: center;
  font-size: 40px;
  border: 2px solid;
  color: #519bcb;
  font-family: Arial, "Times New Roman", Times, serif;
  background-color: #ffffffdd;
  margin: 0 auto;
  border-radius: 5px;
}

div.edit-form-button {
  margin: 0 auto;
}


</style>