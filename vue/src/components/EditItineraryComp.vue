<template>
  <div id="edit-itinerary">
    <div class="edit-form-button" v-show="!showForm">
      <a href="#" v-on:click.prevent="showForm = true">
        <h2 class="edit-header">Edit My Itinerary:</h2>
      </a>
    </div>
    <br />

    <form
      id="itinerary"
      v-on:submit.prevent="updateItinerary()"
      v-if="showForm"
    >

      <div class="input-container">
        <label class="input" for="name">Itinerary Name:</label>
        <input id="name" type="text" class="input-field" v-model="editedItinerary.itineraryName" />
      </div>
      <div class="input-container">
        <label class="input" for="name">Starting Location (Address):</label>
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
    width: 70vw;
    display: flex;
    flex-direction: column; 
    align-items: center; 
}

.input-name,
.input-starting-location {
  display: flex;
  flex-direction: row; 
  align-items: center;
  width: 100%;
  font-size: 15px;
}

label.input {
  padding: 15px;
    margin-bottom: 5px;
}

.input {
  width: 350px; 
  border-radius: 15px;
  font-size: 22px;
}


.input-label {
  width: 200px; 
  text-align: right;
  padding-right: 10px;
}


.input-field {
  flex: 1; 
  padding: 8px;
  border-radius: 15px;
  border: 1px solid #ccc;
  font-size: 20px;
}

.input-container {
  display: flex;
  align-items: center;
  margin-bottom: 15px;
}

div.edit-form-button {
  margin: 0 auto;
}

.edit-header {
  font-size: 30px;
  text-align: center;
  border: 2px solid;
  width: 250px;
  height: 80px;
  margin: 0 auto;
  color: white;
  background-color: rgba(13, 13, 17, 0.667);  
  border-radius: 15px;
  text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);

}

.cancel-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 60%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.cancel-button:hover {
  cursor: pointer;
  color: #FDE75D;
  background-color: rgba(13, 13, 17, 0.667);
}

.reset-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 60%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.reset-button:hover {
  cursor: pointer;
  color: #FDE75D;
  background-color: rgba(13, 13, 17, 0.667);
}

.submit-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 60%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.submit-button:hover {
  cursor: pointer;
  color: #FDE75D;
  background-color: rgba(13, 13, 17, 0.667);
}

.edit-header:hover {
  color: #FDE75D;
}

input[type="text"] {
  font-family: 'Bricolage Grotesque', sans-serif;
  width: 35vw;
}

</style>