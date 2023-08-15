<template>
    <div>
        <div>
            <input type="file" @change="uploadImage">
        </div>
        <div v-if="uploadedImageUrl">
            <img :src="uploadedImageUrl" alt="Uploaded Image" width="300">
        </div>
    </div>
</template>



<script>
import axios from 'axios';

export default {
    data() {
        return {
            uploadedImageUrl: null,
            errorMessage: null
        };
    },
    methods: {
        async uploadImage(event) {
            const file = event.target.files[0];
            if (!file) return;

            const formData = new FormData();
            formData.append('file', file);

            try {
                const response = await axios.post('/upload', formData);
                this.uploadedImageUrl = response.data.imageUrl;
                this.errorMessage = null;
            } catch (error) {
                this.errorMessage = "Failed to upload image.";
                console.error("Upload error:", error);
            }
        }
    }
}

</script>



<style scoped>
.error {
    color: red;
    margin-top: 10px;
}

</style>