import axios from 'axios';

export default {
    addLandmark(landmarkId) {
        return axios.post(`/landmarks/${landmarkId}`);
    }
}