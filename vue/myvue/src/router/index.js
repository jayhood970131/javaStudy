import Vue from "vue"
import VueRouter from "vue-router"
import Content from "../components/Content";
import Main from "../components/Main";

Vue.use(VueRouter);

export default new VueRouter({
  routes: [
    {
       // 路由路径
      path: '/content',

      // 跳转的组件
      component: Content,
      name: 'content1'
    },
    {
      path: '/main',
      name: 'main1',
      component: Main
    }
  ]
})
