<template>
  <div>

    <input type="email">
    <input type="password">
    <button type="button" @click="onLogin">로그인</button>

  </div>
</template>

<script setup>
  import {useAsyncData, useFetch, useRoute} from "nuxt3/app";


  async function onLogin() {


    const users = await fetch('http://localhost:8080/api/test', {mode: 'no-cors'})
    console.log("user" , users);


    

  }

</script>

<style scoped>

</style>