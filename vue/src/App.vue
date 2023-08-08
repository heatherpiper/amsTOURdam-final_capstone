<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{name: 'landmarks'}">Landmarks</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'addlandmark' }">Add Landmark</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'login' }" v-if="$store.state.token = ''">Login</router-link>

      
    </div>
    <router-view />
    <GoogleMapsCompVue/>
  </div>
</template>

<script>
import GoogleMapsCompVue from "./components/GoogleMapsComp.vue";

export default {
  components: {
    GoogleMapsCompVue
    }

}

</script>
