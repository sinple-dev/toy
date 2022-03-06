import { createStore } from "vuex";

export declare namespace indexStore {
  interface state {

  }
}

const initialState: indexStore.state = {

};


export const moduleA = createStore({
  state: initialState,
  // namespace: 'index',

  mutations: {
    increment(state) {
    }
  },
  getters: {
    doubleCount(state, getters, rootState) {
    }
  },
  actions: {
    incrementIfOddOnRootSum() {
    }
  },
});

// export const {state, mutations, getters, actions} = moduleA

