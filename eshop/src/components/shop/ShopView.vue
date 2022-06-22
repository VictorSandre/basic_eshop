<script>
import ProductList from '@/components/shop/ProductList.vue'
import ProductNav from '@/components/shop/ProductNav.vue'
import LoadingComponent from '@/components/global/LoadingComponent.vue'
import PageNotFound from '@/components/error/PageNotFound.vue'
import axios from 'axios'
import { useCartStore } from '@/stores/CartStore'
import { ref } from 'vue'

export default {
  name: 'StoreView',
  components: {
    ProductList,
    ProductNav,
    LoadingComponent,
    PageNotFound
  },
  setup () {
    const cartStore = useCartStore()

    return {
      cartStore,
      current: ref()
    }
  },
  data () {
    return {
      productList: [],
      pagingData: Object,
      links: Object,
      loadingData: true,
      errorLoadingData: false
    }
  },
  computed: {
    isPagesNumberSuperiorToOne () {
      return (this.pagingData.totalPages > 1)
    }
  },
  async created () {
    await this.fetchProducts()
  },
  methods: {
    async fetchProducts (pageNumber = 0, numberItemPerPage = 3) {
      const baseUrl = process.env.VUE_APP_PRODUCTS_API_BASE_URL
      const url = baseUrl + '?page=' + pageNumber + '&size=' + numberItemPerPage

      try {
        const response = await axios.get(url)

        this.productList = response.data._embedded.products
        this.pagingData = response.data.page
        this.links = response.data.links
        this.loadingData = false
        this.errorLoadingData = false
      } catch (error) {
        this.loadingData = false
        this.errorLoadingData = true
      }
    },
    onChangePageData (pageNumber) {
      this.fetchProducts(pageNumber)
    }
  }
}
</script>

<template>
    <div class="shop-container" v-if="!this.loadingData && !this.errorLoadingData">
        <header>
            <router-link
              :to="{name: 'cart'}"
              class="primary-btn cart-btn"
              v-if="this.cartStore.itemNumber > 0"
            >
                Cart ({{ this.cartStore.itemNumber }})
            </router-link>
            <product-nav
                v-if="isPagesNumberSuperiorToOne"
                :lastPage="pagingData.totalPages - 1"
                :currentPage="pagingData.number"
                @change-page-data="onChangePageData"
            />
        </header>
        <div class="product-list-container">
            <product-list :products="productList" class="product-list"/>
        </div>
    </div>
    <div v-else-if="this.errorLoadingData">
      <page-not-found
        :message="'Oups! It seem that we can\'t fetch data. Try to reload the page'"
        :linkMessage="'Try to reload the page'"
        :isLinkPrinted="false"
      />
    </div>
    <div v-else>
        <loading-component/>
    </div>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';

div{
  text-align: center;
}
.shop-container{
  flex-grow: 1;
  @include block-size(100%, 100%);
  @include flex-display(column, center);
  background-color: $third-color;
}
.product-list-container{
  flex-grow: 1;
  @include flex-display(column, center);
}
header{
  @include flex-display(column, center);
}
.cart-btn{
  margin: 10px 10px 0 0;
  align-self: flex-end;
  color: white;
  padding: 1rem 1.5rem 1rem 1.5rem;
  text-transform: uppercase;
  font-weight: bold;
  background: linear-gradient(to left,  $primary-color 50%, white 50%) right;
  background-size: 200%;
  transition:0.5s ease-out;
  &:hover{
    background-position: left;
  }
}
</style>
