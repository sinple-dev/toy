<template>
  <div>
    <Tutorial/>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, useContext } from "@nuxtjs/composition-api";


export default defineComponent({
  name: 'IndexPage',
  layout: 'indexPage',
  async setup(props, context) {


    const { $axios } = useContext()

    onMounted(() => {


    })

  },
  components: {

  }

})
</script>
