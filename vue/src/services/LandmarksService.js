import axios from 'axios';

export default {
    addLandmark(landmark) {
        return axios.post(`/landmarks/add-landmark`, landmark);
    },
    getAllLandmarks() {
        return axios.get(`/landmarks`);
    }
}