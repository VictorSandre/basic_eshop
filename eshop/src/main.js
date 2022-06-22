import { createApp } from 'vue'
import App from './App.vue'
import axios from 'axios'
import VueAxios from 'vue-axios'
import { createPinia } from 'pinia'
import router from './router'

createApp(App).use(router)
  .use(VueAxios, axios)
  .use(createPinia())
  .use(router)
  .mount('#app')
