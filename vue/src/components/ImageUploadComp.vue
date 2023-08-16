<template>
    <div class="hello">
      <button
        v-on:click="defineWidget()"
        id="upload_widget"
        class="cloudinary-button"
      >
        Upload photos
      </button>
    </div>
  </template>
  <script>
  export default {
    name: "HelloWorld",
    props: {
      msg: String,
    },
    data() {
      return {
        myWidget: {},
      };
    },
    methods: {
      defineWidget() {
        const cloudName = "***REMOVED***";
        const uploadPreset = "eadcikpc";
        this.myWidget = window.cloudinary.createUploadWidget(
          {
            cloudName: cloudName,
            uploadPreset: uploadPreset,
            // ... other options
          },
          (error, result) => {
            if (!error && result && result.event === "success") {
              console.log("Done! Here is the image info: ", result.info);
              // document
              //   .getElementById("uploadedimage")
              //   .setAttribute("src", result.info.secure_url);
            }
          }
        ).open();
      },
    },
  };
  </script>


  <style scoped>

  </style>