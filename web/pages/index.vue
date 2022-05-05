<template>
  <Tutorial/>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({

  mounted() {


    const ip = this.$axios.$get('http://localhost:8080/api/test')

    console.log("ip",ip);

  },


})
</script>
