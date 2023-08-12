import axios from "axios";

export default {
    createItinerary(itinerary) {
        return axios.post('/myitinerary/createitinerary', itinerary);
    },

    getMyItinerary(itineraryId) {
        return axios.get(`/myitinerary/${itineraryId}`);
    },

    getItineraries() {
        return axios.get('/myitinerary/');
    },

    getItinerariesByUserId(userId) {
        return axios.get(`/user/${userId}/myitinerary`)
    }
}