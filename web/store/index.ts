
import {ActionContext, StoreOptions} from 'vuex';

interface State {
  count: number;
}

export const userStore: StoreOptions<State> = {
  state: {
    count: 1790,
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

export const {mutations, state, getters, actions} = userStore;


