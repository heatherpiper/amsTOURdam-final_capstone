<template>
  <header>
    <span></span>
    <div id="nav">
      <router-link class="navlink" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'landmarks' }">Landmarks</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'createitinerary'}">My Itineraries</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'addlandmark' }">Add Landmark</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
    </div>
  </header>
</template>

<script>
export default {
  data() {
    return {
      
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