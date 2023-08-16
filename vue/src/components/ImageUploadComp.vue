<template>
    <div>
        <button v-on:click="open" id="upload_widget" class="cloudinary-button">Upload photos</button>
    </div>
</template>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>  

<script type="text/javascript">  
const cloudName = "amsTOURdam";
const uploadPreset = "eadcikpc";

const myWidget = cloudinary.createUploadWidget(
    {
        cloudName: cloudName,
        uploadPreset: uploadPreset,
        sources: [ "local", "url"],
        multiple: true,
        clientAllowedFormats: ["images"],
        maxImageFileSize: 5000000,
        maxImageWidth: 2000,
        maxImageHeight: 2000
    },
    (error, result) => {
        if (!error && result && result.event === "success") {
            console.log("Done! Here is the image info: ", result.info);
            document
                .getElementById("uploadedimage")
                .setAttribute("src", result.info.secure_url);
        }
    }
);

export default {
  name: "UploadWidget",
  data: () => ({
    open: function () {
      myWidget.open();
    },
  }),
  props: {
    msg: String,
  },
};
</script>