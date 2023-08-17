<template>
  <div class="home">
    <div class="home-card">
      <h2>Discover YOUR Amsterdam</h2>
      <body>Build the perfect itinerary to suit your individual needs from our curated list of landmarks and attractions</body>
    </div>
  </div>
</template>

<script>

export default {
  name: "home",
  components: {
   
  },
  data() {
    return {
     
    }
  }
  };
</script>


<style scoped>

h2 {
    text-align: center;
  font-size: 86px;
  border: 2px solid;
  margin: 0 auto;
  border-radius: 5px;
  color: #2ac1d7;
}

#home-card {
  border: 2px solid black;
  border-radius: 20px;
  background-color:  rgba(13, 13, 17, 0.667);
}

body {
  color: white;
}


</style>
