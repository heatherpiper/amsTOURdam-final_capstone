<template>
  <div>
      <h1>Add New Landmark</h1>
      <AddLandmarksComp />
  </div>
</template>

<script>
import AddLandmarksComp from '../components/AddLandmarksComp'

export default {
    components: {
        AddLandmarksComp
    }
}
</script>

<style>
h1 {
  text-align: center;
  font-family: arial Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
}
</style>