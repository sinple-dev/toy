<template>
  <div class="container">
    <div class="col-lg-4 col-md-6 col-sm-8 mx-auto">
      <h1>Sign In</h1>
      <form class="form-group">
        <input :v-model="state.email" type="email" class="form-control" placeholder="Email" required>
        <input :v-model="state.password" type="password" class="form-control" placeholder="Password" required >
        <input type="submit" class="btn btn-primary" @click="doLogin">
      </form>
    </div>
  </div>
</template>

<script lang="ts">
import {defineComponent, onMounted, reactive} from "@vue/composition-api";
import axios from 'axios';

interface State {
  email: string;
  password: string;
}

export default defineComponent({
  setup() {

    const state = reactive<State>({
      email: '',
      password: '',
    });

    async function doLogin() {
      const ip = await axios.get('http://localhost:8081/login');
      console.log(ip);
    }

    return {
      state,
      doLogin
    }

  }
});

</script>
