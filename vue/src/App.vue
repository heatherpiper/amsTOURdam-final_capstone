<template>
  <div id="app">
  <Header />
  <br>
  <main>
    <router-view />
  </main> 
  </div>
</template>

<script>
import Header from './components/Header.vue'



export default {
  components: {
    Header
    
    }

}

</script>
<style scoped>
#app {
  background-color: #F1EFF9;
}
</style>
