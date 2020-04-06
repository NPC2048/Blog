import Vue from 'vue'
import VueRouter from 'vue-router'
import store from '../store/index';

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'blogList',
    component: () => import('../views/BlogList'),
    meta: {
      isLogin: true
    }
  }, {
    path: '/login',
    name: 'login',
    component: () => import('../views/Login')
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});
// 路由拦截

router.beforeEach((to, from, next) => {
  // 该组件是否需要登录
  if (to.meta.isLogin) {
    // 当前用户是否已登录
    if (store.state.token) {
      // 放行
      return next();
    }
    // 跳转到登录页面
    return next({
      path: '/login',
      query: {
        redirect: to.fullPath
      }
    })
  }
  next();
});

export default router
