import axios from 'axios';

export default {
    addLandmark(landmark) {

        return axios.post('landmarks', landmark);
    },

    getAllLandmarks() {
        return axios.get('/landmarks/')
    },

    getLandmarkById(landmarkId) {
        return axios.get(`/landmarks/${landmarkId}`)
    }
}