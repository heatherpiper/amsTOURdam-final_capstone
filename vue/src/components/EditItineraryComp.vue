<template>
  <div id="edit-itinerary">
    <div class="edit-form-button" v-show="!showForm">
      <a href="#" v-on:click.prevent="showForm = true">
        <h2 class="edit-header">Edit Itinerary:</h2>
      </a>
    </div>
    <br />

    <form
      id="itinerary"
      v-on:submit.prevent="updateItinerary()"
      v-if="showForm"
    >

      <div class="input-container">
        <label for="name">Itinerary Name:</label>
        <input id="name" type="text" class="input-field" v-model="editedItinerary.itineraryName" />
      </div>
      <div class="input-container">
        <label for="name">Starting Location (Address):</label>
        <input
          id="starting-location"
          type="text" 
          class="input-field"
          v-model="editedItinerary.startingLocation"
        />
      </div>

      <div class="create-buttons">
        <input class="cancel-button" v-on:click.prevent="hideForm" type="button" value="Cancel" />
        <input class="reset-button"
          v-on:click.prevent="resetForm()"
          type="button"
          value="Reset Form"
        />
        <button class="submit-button" type="submit">Update</button>
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
        itineraryId: '',
        itineraryName: '',
        startingLocation: '',
        latitude: '',
        longitude: '',
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
    getItineraryData(itineraryId) {
    ItineraryService.getMyItinerary(itineraryId)
      .then((response) => {
        console.log(response);
        this.editedItinerary = response.data;
      })
      .catch(function (error) {
        if (error.response) {
          if (error.response.status == 404) {
            alert(error.response.data.message);
          }
        }
      });
  },
    updateItinerary() {


      ItineraryService.updateItineraryByItineraryId(
      
        this.editedItinerary
      )
        .then((response) => {
          if (response.status === 200) {
            if (response.data) {
              this.editedItinerary = response.data;
              this.$store.commit("UPDATE_ITINERARY", this.editedItinerary);
              console.log(this.editedItinerary);
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
  
  created() {
    this.getItineraryData(this.$route.params.id);
    //console.log(this.$route.params.itineraryId);
    console.warn("im here" + this.$route.params.id)
  },
};
</script>

<style scoped>

form {
    text-align: center;
    font-size: 30px;
    font-weight: bold;
    border: 2px solid;
    color: #519BCB;
    background-color: rgba(13, 13, 17, 0.667);
    margin: 0 auto;
    border-radius: 15px;
    padding: 40px 0;
    max-width: 900px;
    display: flex; /* Use flexbox to align form elements */
    flex-direction: column; /* Stack elements vertically */
    align-items: center; /* Center items horizontally */
}

.input-name,
.input-starting-location {
  display: flex;
  flex-direction: row; /* Change to column to stack inputs vertically */
  align-items: center;
  width: 100%;
}

label.input {
  padding: 15px;
    margin-bottom: 5px;
}

.input {
  width: 300px; /* Use full width for input fields */
  border-radius: 15px;
 
}

/* Add this style for input labels */
.input-label {
  width: 200px; /* Set a fixed width for labels to align them */
  text-align: right;
  padding-right: 10px;
}

/* Add this style for input fields */
.input-field {
  flex: 1; /* Expand input fields to fill remaining space */
  padding: 8px;
  border-radius: 15px;
  border: 1px solid #ccc;
}

/* Add this style for input containers */
.input-container {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
}

div.edit-form-button {
  margin: 0 auto;
}

.edit-header {
  font-size: 50px;
  text-align: center;
  border: 2px solid;
  width: 450px;
  height: 80px;
  margin: 0 auto;
  color: white;
  background-color: #519BCB;
  border-radius: 15px;

}

.cancel-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
}

.cancel-button:hover {
  cursor: pointer;
}

.reset-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
}

.reset-button:hover {
  cursor: pointer;
}

.submit-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
}

.submit-button:hover {
  cursor: pointer;
}

.create-header:hover {
  color: darksalmon;
}

</style>