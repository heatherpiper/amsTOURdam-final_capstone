<template>
  <header>
    
    <div id="nav">
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'landmarks' }">Landmarks</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'adminitineraries'}">Admin Itineraries</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'myitineraries'}" v-if="$store.state.token !== ''">My Itineraries</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'addlandmark' }" v-if="isAdmin()">Add Landmark</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
      <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''" >Login</router-link>
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

<style>
header {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 100px;
}

#nav {
    padding: 20px;
    font-size: 20px;
    font-family: 'Inter', sans-serif;
    font-weight: 600;
    border-radius: 10px;
}

.navlink {
    text-decoration: none;
    color: #2ac1d7;
}

.navlink:hover {
    color: #2ac1d7;
}

</style>