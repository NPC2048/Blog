import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter);

const routes = [
  {
    path: '/',
    name: 'blogList',
    component: () => import('../views/BlogList')
  },
  {
    path: '/login',
    name: 'login',
    component: () => import('../views/user/Login.vue')
  }, {
    path: '/register',
    name: 'register',
    component: () => import('../views/user/Register')
  }
];

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
});

export default router
