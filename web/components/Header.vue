<template>
  <div>
    <NuxtLink to="/">시작</NuxtLink>
    <NuxtLink to="/main">메인</NuxtLink>
    <NuxtLink to="/login">로그인</NuxtLink>
  </div>
</template>
<script lang="ts">
import {defineComponent} from "@vue/composition-api";
export default defineComponent({
  setup() {

  },
});
</script>
<style lang="scss" scoped>
  div {
    width: 100%;
    height: 50px;
  }
</style>

