
import MainLayout from '../layouts/inc/MainLayout.vue'
import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import UserListing from '../views/Users/UserListing.vue'
import UserProfile from '../views/Users/UserProfile.vue'
import UserForm from '@/views/Users/UserForm.vue'

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
        path: '/users/edit/:id',
        name: 'userEdit',
        component: UserForm,
        props: true
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
      },

      {
        path: '/newUser',
        name: 'newUser',
        component: UserForm
      }

    ]
  }
]

const router = createRouter({

  history: createWebHistory(process.env.BASE_URL),
  routes
  
})

export default router