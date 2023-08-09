<template>
  <div class="home">
    <h1>Welcome To Amsterdam!</h1>
    <p></p>
    <div class="googlemap-container">
      <GoogleMapsCompVue/>
    </div>
  </div>
</template>

<script>
import GoogleMapsCompVue from "../components/GoogleMapsComp.vue";

export default {
  name: "home",
  components: {
    GoogleMapsCompVue
  }
};
</script>

<style scoped>
h1 {
  text-align: center;
  font-size: 60px;
  border: 10px solid rgb(102, 3, 89);
  border-style: double;
  color: rgb(58, 2, 58);
  font-family: Georgia, 'Times New Roman', Times, serif;
  background-color: rgb(231, 163, 17);
  width: 900px;
  margin: 0 auto;
}

div home {
  position: relative;
}

div .googlemap-container {
  position: absolute;
  left: 48%;
  
}
</style>
