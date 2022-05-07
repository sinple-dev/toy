import Vue from 'vue';
import Vuex, {ActionContext, StoreOptions} from 'vuex';

Vue.use(Vuex);

interface State {
  count: number;
}

export const store: StoreOptions<State> = {
  state: {
    count: 0,
  },
  mutations: {
    setCount(state: State, count: number) {
      state.count = count;
    },
  },
  actions: {
    increase({state, commit}: ActionContext<State, State>) {
    },
    decrease({state, commit}: ActionContext<State, State>) {
    },
  },
  getters: {
    count: (state: State) => state.count,
  },
};

export const {mutations, state, getters, actions} = store;
