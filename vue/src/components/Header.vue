<template>
<div>
  <nav>
 
    <ul class="nav-list">
      <li id="logo-container">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'home' }">
          <img id="logo" src="../media/assets/logo-color.png" alt="">
        </router-link>
      <li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'home' }">Home</router-link>
      </li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'landmarks' }">Explore Locations</router-link>
      </li>
      <!-- <li>
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'adminitineraries'}">Admin Itineraries</router-link>
      </li> -->
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'myitineraries'}" v-if="$store.state.token !== ''">Make Plans</router-link>
      </li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'createroute'}" v-if="$store.state.token !== ''">Map Your Way</router-link>
      </li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'addlandmark' }" v-if="isAdmin()">Add Landmark</router-link>
      </li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
      </li>
      <li class="nav-item">
        <router-link class="navlink" @click.prevent.stop v-bind:to="{ name: 'login' }" v-if="$store.state.token == ''" >Login</router-link>
      </li>
    </ul>
  </nav>
  </div>
</template>

<script>
import store from '../store/index'
export default {
  name: 'NavigationBar',

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

.nav-list {
  display: flex;
  justify-content: right;
  align-items: center;
  list-style: none;
  padding: 0px;
}

/* .nav-item {
  margin-left: auto;
} */

nav {
  /* mask-image: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, #ffffff 25%, #ffffff 75%, rgba(255, 255, 255, 0) 100%); */
  margin: 0 auto;
  padding: 20px 0 0 0;
  z-index: 1000;
}

nav ul {
  text-align: left; 
  background: linear-gradient(90deg, rgba(255, 255, 255, 0) 0%, rgba(255, 255, 255, 0.2) 25%, rgba(255, 255, 255, 0.2) 75%, rgba(255, 255, 255, 0) 100%);
  width: 100%;
  box-shadow: 0 0 25px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
}

nav ul li {
  display: inline-block;
}

nav ul li a {
  padding: 20px;
  font-family: 'Inter', sans-serif;
  color: rgba(0, 0, 0, 0.5);
  text-shadow: 1px 1px 1px rgba(255, 255, 255, 0.4);
  font-size: 22px;
  text-decoration: none;
  display: block;
}

.nav-item:hover {
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1), inset 0 0 1px rgba(255, 255, 255, 0.6);
  background: rbga(255, 255, 255, 0.1);
  color: rgba(0, 0, 0, 0.7);
}

nav ul li a #logo-container:hover {
  box-shadow: none;
}

#logo-container {
  display: flex;
  margin: 20px 30% 5px 10px;
}

#logo {
  width: 220px;
}

</style>