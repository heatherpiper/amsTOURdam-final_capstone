import axios from 'axios';

const landmarksApi = axios.create({
    baseURL: 'http://localhost:8080'
});

export default {
    addLandmark(landmarkId) {
        return landmarksApi.post(`/landmarks/${landmarkId}`);
    }
}