<template>
  <div>
      어드민 인덱스 페이지


  </div>
</template>

<script>
import Vue from 'vue';
export default Vue.extend({
  async created(){


    const albums = await this.$axios.$get("/api/home");

    console.log(albums)

  }
})
</script>

<style scoped>

</style>