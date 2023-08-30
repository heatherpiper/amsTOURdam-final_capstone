<template>
    <div class="hello">
      <button
        v-on:click="defineWidget()"
        id="upload_widget"
        class="cloudinary-button"
      >
        Upload Photos from Your Visit!
      </button>
      <br>
      <br>
      <img id="uploadedimage" />
      <br>
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
        const cloudName = "**REMOVED**";
        const uploadPreset = "eadcikpc";
        this.myWidget = window.cloudinary.createUploadWidget(
          {
            cloudName: cloudName,
            uploadPreset: uploadPreset,
            sources: [ 'local', 'url', 'google_drive', 'dropbox' ],
            tags: [ 'user-uploads', 'landmark' ],
            resourceType: 'image',
            maxFileSize: '1500000',
          },
          (error, result) => {
            if (!error && result && result.event === "success") {
              console.log("Done! Here is the image info: ", result.info);
              document
                 .getElementById("uploadedimage")
                 .setAttribute("src", result.info.secure_url);
            }
          }
        ).open();
      },
    },
  };
  </script>


  <style scoped>

  button.cloudinary-button {
    font-family: 'Bricolage Grotesque', sans-serif;
    background-color: #298a91;
    border-radius: 15px;
    text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.3);
    font-size: 20px;
  }

  button.cloudinary-button:hover {
    cursor: pointer;
    color: #FDE75D;
  }

  img {
    width: 35vw;
    height: 20vw;
  }

  </style>