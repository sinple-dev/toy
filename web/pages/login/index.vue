<template>
  <div>
    <b-button>로그인</b-button>
  </div>
</template>

<script lang="ts">
import { defineComponent, onMounted} from "@vue/composition-api";
import axios from 'axios';

export default defineComponent({
  async setup() {

    onMounted(async () => {
      await onFetch();
    });

    async function onFetch() {
      const ip = await axios.get('http://localhost:8080/api/test');
      console.log(ip);
    }

  }
});

</script>
