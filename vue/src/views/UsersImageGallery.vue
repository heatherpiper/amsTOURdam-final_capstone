<template>
    <div>
        <div id="gallery">
        <img class="image" v-for="(image, i) in images" :src="image" @click="onClick(i)">
        <vue-gallery-slideshow :images="images" :index="index" @close="index = null"></vue-gallery-slideshow>
</div>
    </div>
</template>

<script>
import VueGallerySlideshow from 'vue-gallery-slideshow'


const app = new Vue({
  el: '#app',
  components: {
    VueGallerySlideshow
  },
  methods: {
    onClick(i) {
      this.index = i;
    }
  },
  data: {
    images: [
      'https://placekitten.com/801/800',
      'https://placekitten.com/802/800',
      'https://placekitten.com/803/800',
      'https://placekitten.com/804/800',
      'https://placekitten.com/805/800',
      'https://placekitten.com/806/800',
      'https://placekitten.com/807/800',
      'https://placekitten.com/808/800',
      'https://placekitten.com/809/800',
      'https://placekitten.com/810/800'
    ],
    index: 0
  }
})
</script>

<style>

</style>