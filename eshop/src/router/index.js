import { createRouter, createWebHistory } from 'vue-router'
import ShopView from '@/views/ShopView.vue'
import CartView from '@/views/CartView.vue'
import AboutView from '@/views/AboutView.vue'
import PageNotFoundView from '@/views/PageNotFoundView.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: {name : 'shop'}
  },
  {
    path: '/Shop',
    name: 'shop',
    component: ShopView
  },
  {
    path: '/Shop/Cart',
    name: 'cart',
    component: CartView
  },
  {
    path: '/about',
    name: 'about',
    component: AboutView
  },
  {
    path: '/:pathMatch(.*)*',
    name: 'not-found',
    component: PageNotFoundView
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
