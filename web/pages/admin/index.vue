<template>
  <div>
      어드민 인덱스 페이지


  </div>
</template>

<script setup>

  import {useAsyncData, useRoute} from "nuxt3/app";
  import { $fetch } from 'ohmyfetch';

  const route = useRoute();

  const { users } = $fetch('http://localhost:8080', {mode: 'no-cors'})

  console.log(users);


    // const albums = await this.$axios.$get("/api/home");
</script>

<style scoped>

</style>