<template>
  <header>
    <span></span>
    <div id="nav">
      <router-link class="navlink" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'landmarks' }">Landmarks</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'adminitineraries'}">Admin Itineraries</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'myitineraries'}" v-if="$store.state.token !== ''">My Itineraries | </router-link>
      <router-link class="navlink" v-bind:to="{ name: 'addlandmark' }" v-if="isAdmin()">Add Landmark | </router-link>
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
      <router-link class="navlink" v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''" >Login</router-link>
    </div>
  </header>
</template>

<script>
import store from '../store/index'
export default {

  data() {
    return {
      
    }
  },
  methods: {
    isAdmin() {
      if(store.state.user.authorities && store?.state?.user?.authorities[0].name === 'ROLE_ADMIN') {
        return true;
      } 
      return false;
    }
  }
};
</script>

<style scoped>
header {
  background-color: #f1eff9;
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100px;
}

#nav {
    padding: 20px;
    font-size: 20px;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
    background-color: white;
    border-radius: 10px;
}

.navlink {
    text-decoration: none;
    color: black;
}

.navlink:hover {
    color: #519bcb;
}

#logo {
  max-width: 10px;
}

</style>