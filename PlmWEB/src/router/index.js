import Vue from 'vue'
import Router from 'vue-router'

import index from '@/views/data/index'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      component: index
    }
    ,
    {
      path: '/v2',
      name: 'indexv2',
      component: (resolve) => require(['@/views/QaData/index'], resolve),
    }
    // ,
    // {
    //   path: '/login',
    //   name: 'login',
    //   component: (resolve) => require(['@/views/login'], resolve),
    // }
  ]
})
