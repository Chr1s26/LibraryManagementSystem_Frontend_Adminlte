
import MainLayout from '../layouts/MainLayout.vue'
import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserListing from '../views/Users/UserListing.vue'
import UserProfile from '../views/Users/UserProfile.vue'

const routes: Array<RouteRecordRaw> = [
  {
    path : '/',
    component: MainLayout,
    children: [
      {
        path: '/',
        name: 'home',
        component: HomeView,
      },
      {
        path: '/users/:id',
        name: 'userProfile',
        component: UserProfile,
        props: true
      },
      {
        path:'/Users',
        name: 'Users',
        component: UserListing,
      },
      {
            path: '/about',
            name: 'about',
            component:  () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
      }
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router