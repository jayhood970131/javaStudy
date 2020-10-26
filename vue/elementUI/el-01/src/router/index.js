import Vue from 'vue'
import Router from 'vue-router'
import Button from 'components/button/button'
import ButtonDetail from 'components/button/button-detail'
import Layout from "components/layout/layout";

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/button',
      component: Button
    },
    {
      path: '/buttonDetail',
      component: ButtonDetail
    },
    {
      path: '/layout',
      component: Layout
    }
  ]
})
