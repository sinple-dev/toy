<template>
  <div>
    어드민 인덱스 페이지


    {{ test }}
  </div>
</template>

<script setup>

import {useAsyncData, useFetch, useRoute} from "nuxt3/app";

const route = useRoute();

// const users = await fetch('http://localhost:8080/api/test', {mode: 'no-cors'})

const { data } = await useFetch('http://localhost:8080/api/test')
console.log("data" , data);


let test = "";


fetch("http://localhost:8080/api/test", {
  method: "GET",
  mode: 'no-cors',
  headers: {
    "Content-Type": "application/json"
  },
}).then(function (response) {
  console.log("teset" , response);
  return response.text();
}).then(function (item) {
  console.log("item", item)
  test = item;
});


</script>

