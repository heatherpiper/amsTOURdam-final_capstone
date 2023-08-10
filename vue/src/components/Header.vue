<template>
  <header>
    <div id="nav">
      <router-link class="navlink" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'landmarks' }">Landmarks</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'createitinerary'}">My Itinerary</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'addlandmark' }">Add Landmark</router-link>&nbsp;|&nbsp;
      <router-link class="navlink" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''" >Logout</router-link>
    </div>
  </header>
</template>

<script>
export default {
  data() {
    
  }
};
</script>

<style scoped>
header {
  background-color: rgb(146, 141, 144);
  display: flex;
  align-items: center;
  justify-content: right;
  height: 100px;
  border: 2px rgb(58, 2, 58) solid;
}

#nav {
    padding: 20px;
    font-size: 30px;
    font-family:Verdana, Geneva, Tahoma, sans-serif;
}

.navlink {
    text-decoration: none;
    color:rgb(32, 7, 56);
}

.navlink:hover {
    color:deeppink
}

</style>