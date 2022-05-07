<template>
  <div>
    <b-button>로그인</b-button>
  </div>
</template>

<script lang="ts">
import {defineComponent} from "@vue/composition-api";

import {store} from "@/store/index";

export default defineComponent({
  async mounted() {

    const ip = await this.$axios.$get('http://localhost:8080/api/test')

    console.log("ip",ip);

  },
  setup() {

  }
});
</script>
<style lang="scss" scoped>

</style>
