<template>
  <div>
    {{ state }}
    메인 페이지
  </div>
</template>

<script lang="ts">
import {defineComponent, reactive} from "@vue/composition-api";

interface State {
  id: number;
}

export default defineComponent({
  setup() {
    const state = reactive<State>({
      id: 999,
    });
    return {
      state,
    };
  }
});
</script>

<style scoped>

</style>
