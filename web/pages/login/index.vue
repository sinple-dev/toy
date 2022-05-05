<template>
  <div>
    <b-button>로그인</b-button>
  </div>
</template>

<script lang="ts">
import Vue from 'vue'

export default Vue.extend({
  async mounted() {

    const ip = await this.$axios.$get('http://localhost:8080/api/test')

    console.log("ip",ip);

  },

});

</script>

<style scoped>

</style>
