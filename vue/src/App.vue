<template>
  <div id="app">
  <Header />
  <br>
  <main class="flexbox">
    <router-view />
  </main> 
  </div>
</template>

<script>
import Header from './components/Header.vue'

export default {
  components: {
    Header,
    }

}
</script>


<style>
 /* #app {
  background-image: url("media/assets/HomeBG.jpg"); 
  margin: 0;
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-position: center;
  background-size: auto;
} */

</style>
