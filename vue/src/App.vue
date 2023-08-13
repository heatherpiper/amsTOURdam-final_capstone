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

</style>
