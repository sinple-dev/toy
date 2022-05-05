<template>
  <div>

    {{ state }}
    aaaaaaaaaaa
    {{ count }}
    tesetstset

    {{message}}
    <button @click="count++">{{ count }}</button>

  </div>
</template>
<script lang="ts">
import {defineComponent, onMounted, reactive, ref} from "@vue/composition-api";

interface State {
  id: number;
}

export default defineComponent({
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

  data() {
    return {
      message: 'not updated'
    }
  },

});
</script>
