<template>
  <div>
    인덱스 페이지
  </div>
</template>
<script lang="ts">
import {onMounted, reactive, ref} from "@vue/composition-api";

interface State {
  id: number;
}

export default {
  layout: 'main',
  setup() {
    const state = reactive<State>({
        id: 1,

    });
    const count = ref(0)

    onMounted(async () => {
    });

    return {
      state,
      count,
    };
  },
};
</script>
