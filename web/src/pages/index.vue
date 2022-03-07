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

    const context1 = useContext();


    onMounted(() => {

      // const asdf: string = context1.$axios.get('/home');
      // console.log(asdf)


    })

  },
  components: {

  }

})
</script>
