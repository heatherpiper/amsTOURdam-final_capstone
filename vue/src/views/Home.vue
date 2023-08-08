<template>
  <div class="home">
    <h1>Welcome To Amsterdam!</h1>
    <p></p>
    <GoogleMapsCompVue/>
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
  font-family: arial Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>
