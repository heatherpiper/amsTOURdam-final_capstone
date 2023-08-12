<template>
  <div id="create-itinerary">
    <h1>Create an Itinerary:</h1>
    <br />
    <form id="itinerary" v-on:submit.prevent="createItinerary()">
      <div class="input-name">
        <label for="name">Itinerary Name:</label>
        <input id="name" type="text" v-model="createdItinerary.itineraryName" />
      </div>
      <div class="input-starting-location">
        <label for="name">Starting Location:</label>
        <input
          id="starting-location"
          type="text"
          v-model="createdItinerary.startingLocation"
        />
      </div>
      <div class="actions">
        <button v-on:click="resetForm()" type="button">Reset</button>
        <button type="submit">Submit</button>
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
      createdItinerary: {
        itineraryId: "",
        itineraryName: "",
        startingLocation: "",
        latitude: "",
        longitude: "",
      },
    };
  },
  methods: {
    createItinerary() {
      ItineraryService.createItinerary(this.createdItinerary)
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