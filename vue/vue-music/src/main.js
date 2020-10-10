import Vue from 'vue'
import App from './App'
import router from './router'
import 'babel-polyfill'
import fastclick from 'fastclick'
import Axios from 'axios'
import 'common/stylus/index.styl'

Vue.prototype.$axios = Axios

fastclick.attach(document.body)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  render: h => h(App)
})
