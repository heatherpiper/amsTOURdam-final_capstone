import axios from "axios";

export default {
    createItinerary(itinerary) {
        return axios.post('/createitinerary', itinerary);
    },

    createItineraryByUserId(userId, itinerary) {
        return axios.post(`/createitinerarybyuser/${userId}`, itinerary);
    },

    getMyItinerary(itineraryId) {
        return axios.get(`/myitinerary/${itineraryId}`);
    },

    getItineraries() {
        return axios.get('/itineraries');
    },

    getItinerariesByUserId(userId) {
        return axios.get(`/myitineraries/${userId}`);
    },

    deleteItinerary(itineraryId) {
        return axios.delete(`/myitinerary/${itineraryId}`);
    },

    getLandmarksByUserAndItineraryId(userId, itineraryId) {
        return axios.get(`myitinerary/${itineraryId}/addlandmarks/${userId}`);
    },
    
    updateItineraryByItineraryId(itinerary) {
        return axios.put(`/myitinerary/${itinerary.itineraryId}`, itinerary);
    },

    addLandmarkToUserListByItineraryId(itineraryId, landmarkId) {
        return axios.post(`/myitinerary/${itineraryId}/addlandmark/${landmarkId}`);
    },
    removeLandmarkFromItineraryByLandmarkId(itineraryId, landmarkId) {
        return axios.delete(`/myitinerary/${itineraryId}/delete/${landmarkId}`);
    }


}