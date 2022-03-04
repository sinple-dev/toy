<template>
  <div>
    <NuxtWelcome />
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted} from "@vue/composition-api/dist/vue-composition-api";
  export default defineComponent({
    name: 'about',
    async setup() {

      const number: number = 0;

      onMounted(() => console.log("component mounted"));


    },

  })
</script>