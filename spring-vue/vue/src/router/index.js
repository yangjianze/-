import { createRouter, createWebHistory } from 'vue-router'
import Layout from '../layout/Layout.vue'

const routes = [
  {
    path: '/',
    name: 'Layout',
    component: Layout,
    redirect:"/login",//重定向到login
    children:[{
      // 当 /home 匹配成功，
      // @/views/Home 会被渲染在 Layout 的 <router-view> 中
      path:'/home',
      name:'/Home',
      component:()=>import('@/views/Home')
    },{
      path:'/Main',
      name:'/main',
      component:()=>import('@/views/Main')
    },{
      path:'/Classs',
      name:'/classs',
      component:()=>import('@/views/Classs')
    },{
      path:'/Dormitoryinfo',
      name:'/dormitoryinfo',
      component:()=>import('@/views/Dormitoryinfo')
    },{
      path:'/Dormrepair',
      name:'/dormrepair',
      component:()=>import('@/views/Dormrepair')
    },{
      path:'/Dormgrade',
      name:'/dormgrade',
      component:()=>import('@/views/Dormgrade')
    },{
      path:'/Stgrade',
      name:'/stgrade',
      component:()=>import('@/views/Stgrade')
    },{
      path:'/Visitor',
      name:'/visitor',
      component:()=>import('@/views/Visitor')
    },{
      path:'/Admins',
      name:'/admins',
      component:()=>import('@/views/Admins')
    },{
      path:'/Blogs',
      name:'/blogs',
      component:()=>import('@/views/Blogs')
    },{
      path:'/Exploit',
      name:'/exploit',
      component:()=>import('@/views/Exploit')
    },{
      path:'/Homeecharts',
      name:'/homeecharts',
      component:()=>import('@/views/Homeecharts')
    }]
  },
  {
    path: '/Login',
    name: 'Login',
    component: () => import('@/views/Login')
  },
  // {
  //   path: '/Versions',
  //   name: 'versions',
  //   component: () => import('@/views/Versions')
  // }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
