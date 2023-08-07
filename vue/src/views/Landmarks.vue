<template>
  <div class="landmarks">
      <h1>Landmarks</h1>
    <LandmarksComp />
    <AddLandmarksComp />
  </div>
</template>

<script>
import LandmarksComp from '@/components/LandmarksComp'
import AddLandmarksComp from '@/components/AddLandmarksComp'

export default {
    components: {
        LandmarksComp,
        AddLandmarksComp
    }
}
</script>

<style>

</style>