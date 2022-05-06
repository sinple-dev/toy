import Vue from 'vue';
import moment from 'moment';

Vue.mixin({
  filters: {
    date(value: Date) {
      moment(value).toDate();
    },
  },
})
