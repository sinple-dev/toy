<template>
  <div>
    <Header/>
    <Nuxt/>
  </div>
</template>
<script lang="ts">
import {defineComponent} from "@vue/composition-api";
import Header from '~/components/Header.vue';

export default defineComponent({
  components: {
    Header
  }
});

</script>

