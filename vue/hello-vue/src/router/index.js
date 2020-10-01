import Vue from 'vue';
import VueRouter from 'vue-router'

import Main from "../views/Main";
import Login from "../views/Login";

import UserList from "../views/user/List"
import UserProfile from "../views/user/Profile"
import NotFound from "../views/NotFound";

Vue.use(VueRouter);

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/login',
      component: Login
    },
    {
      path: '/main/:name',
      component: Main,
      props: true,
      children: [
        {path: '/user/profile/:id', component:UserProfile, name: 'UserProfile', props: true},
        {path: '/user/list', component: UserList}
      ]
    },
    {
      path: '/goHome',
      redirect: '/main'
    },
    {
      path: '*',
      component: NotFound
    }
  ]
})
