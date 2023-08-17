<template>
  <div id="create-itinerary">
    <div class="create-form-button" v-show="!showForm">
            <a href="#" v-on:click.prevent="showForm = true">
              <h2 class="create-header">Create an Itinerary:</h2>
            </a>
        </div>
    <br />
    <form id="itinerary" v-on:submit.prevent="createItinerary()" v-if="showForm">
      <div class="input-name">
        <label class="input" for="name" >Itinerary Name:</label>
        <input id="name" type="text" placeholder="Name your Itinerary" v-model="createdItinerary.itineraryName" />
      </div>
      <div class="input-starting-location">
        <label class="input"  for="name" >Starting Location:</label>
        <input
          id="starting-location"
          type="text"
          placeholder="Type in an Address"
          v-model="createdItinerary.startingLocation"
        />
      </div>

      <div class="create-buttons">
        <input class="cancel-button" v-on:click.prevent="hideForm" type="button" value="Cancel"  />
        <input class="reset-button" v-on:click.prevent="resetForm()" type="button" value="Reset Form" />
        <input class="submit-button" type="submit" value="Submit Form" v-bind:disabled="!isFormValid" />
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
      userId: "",
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
      this.userId = this.$store.state.user.id;
      
      ItineraryService.createItineraryByUserId(this.userId, this.createdItinerary)
        .then((response) => {
          if (response.status === 201) {
            if (response.data && response.data.itineraryId) {
              this.createdItinerary = response.data;
              this.$store.commit("ADD_ITINERARY", this.createdItinerary);
              console.log(this.createdItinerary);
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
    max-width: 700px;
    display: flex; 
    flex-direction: column; 
    align-items: center; 
}

.input-name,
.input-starting-location {
    display: flex;
    flex-direction:row;
    align-items: center;
     width: 100%;
     font-size: 22px;
   
}

#name, #starting-location {
  border-radius: 15px;
}

label.input {
  padding: 15px;
  margin-bottom: 5px;
}

.input {
  width: 300px; 
  border-radius: 15px;
}


div.create-form-button {
  margin: 0 auto;
}

.create-header {
  font-size: 30px;
  text-align: center;
  border: 2px solid;
  width: 250px;
  height: 80px;
  margin: 0 auto;
  color: white;
  background-color: rgba(13, 13, 17, 0.667);
  border-radius: 15px;

}

.cancel-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.cancel-button:hover {
  cursor: pointer;
  color: darksalmon;
  background-color: rgba(13, 13, 17, 0.667);
}

.reset-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.reset-button:hover {
  cursor: pointer;
  color: darksalmon;
  background-color: rgba(13, 13, 17, 0.667);
}

.submit-button {
  padding: 4px;
  margin: 15px;
  border-radius: 15px;
  font-size: 80%;
  font-family: 'Bricolage Grotesque', sans-serif;
}

.submit-button:hover {
  cursor: pointer;
  color: darksalmon;
  background-color: rgba(13, 13, 17, 0.667);
}

.create-header:hover {
  color: darksalmon;
  cursor: pointer;
}

input[type="text"]::placeholder {
  color: #999;
  font-family: 'Bricolage Grotesque', sans-serif;
}

</style>