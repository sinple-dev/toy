<template>
  <Tutorial/>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  name: 'IndexPage',

  mounted() {
    console.log("Asdfa", process.env)
    console.log("Asdfa", process.env.NODE_ENV)
    console.log("Asdfa", process.env.BUILD_ENV)
  }
})
</script>
