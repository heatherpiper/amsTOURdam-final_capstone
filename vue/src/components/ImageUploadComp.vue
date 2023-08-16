<template>
    <div>
        <button v-on:click="open" id="upload_widget" class="cloudinary-button">Upload photos</button>
    </div>
</template>

<script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>  

<script type="text/javascript">  

export default {
  name: "UploadWidget",
  data: () => ({
    myWidget: null,
    open: function () {
      this.myWidget.open();
    },
  }),
  mounted() {
    this.myWidget = cloudinary.createUploadWidget(
      {
        cloudName: "amsTOURdam",
        uploadPreset: "eadcikpc",
        sources: ["local", "url"],
        multiple: true,
        clientAllowedFormats: ["images"],
        maxImageFileSize: 5000000,
        maxImageWidth: 2000,
        maxImageHeight: 2000
      },
      (error, result) => {
        if (!error && result && result.event === "success") {
          this.$emit('image-uploaded', result.info.secure_url);
        }
      }
    );
  },
  props: {
    msg: String,
  },
};
</script>