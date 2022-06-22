import { createRouter, createWebHistory } from 'vue-router'
import ShopView from '@/components/shop/ShopView.vue'
import CartView from '@/components/shop/cart/CartView.vue'
import AboutView from '@/components/AboutView.vue'
import PageNotFound from '@/components/error/PageNotFound.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    redirect: { name: 'shop' }
  },
  {
    path: '/shop',
    name: 'shop',
    component: ShopView
  },
  {
    path: '/shop/cart',
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
    component: PageNotFound
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
