import VueRouter from 'vue-router'
import Vue from 'vue'

import Login from "../views/Login";

Vue.use(VueRouter);

const routes = [
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login')
  }
]

export default new VueRouter({
  routes: routes

})


