import axios from "axios";

export default {
    createItinerary(itinerary) {
        return axios.post('/createitinerary', itinerary);
    },

    getMyItinerary(itineraryId) {
        return axios.get(`/myitinerary/${itineraryId}`);
    },

    getItineraries() {
        return axios.get('/itineraries');
    },

    getItinerariesByUserId(userId) {
        return axios.get(`/myitineraries/${userId}`);
    }
}