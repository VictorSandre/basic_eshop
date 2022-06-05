<script>
import ProductList from '@/components/shop/ProductList.vue'
import PageNavBar from '@/components/shop/PageNavBar.vue'
import axios from 'axios'
import { useCartStore } from '../stores/CartStore'
import { ref } from 'vue'

export default {
    name: "StoreView",
    components: { 
        ProductList,
        PageNavBar,
    },
    setup () {
        const cartStore = useCartStore()
        
        return {
            cartStore,
            current: ref(),
        };
    },
    data () {
        return {
            productList: [],
            pagingData: Object,
            links: Object,
            loadingData: true,
            errorLoadingData: false,
        }
    },
    computed: {
        isPagesNumberSuperiorToZero() {
            if ((this.pagingData.totalPages - 1) <= 0) {
                return false;
            }
            else {
                return true;
            }
        }
    },
    async created () {
        await this.fetchProducts()
    },
    methods: {
        async fetchProducts(pageNumber = 0, numberItemPerPage = 3) {
            const baseUrl = 'http://192.168.1.25:8081/products'
            const url = baseUrl + '?page=' + pageNumber + '&size=' + numberItemPerPage
            
            try {
                const response = await axios.get(url)
            
                this.productList = response.data._embedded.products;
                this.pagingData = response.data.page;
                this.links = response.data.links;
                this.loadingData = false;
                this.errorLoadingData = false;
            } catch (error) {
                this.loadingData = false;
                this.errorLoadingData = true;
            }    
        },
        onChangePageData(pageNumber) {
            this.fetchProducts(pageNumber)
        }
    }
}
</script>

<template>
    <div class="shop-container" v-if="!this.loadingData && !this.errorLoadingData">
        <header>
             <button class="primary-btn cart-btn" v-if="this.cartStore.itemNumber > 0">
                <router-link :to="{name: 'cart'}">
                    Cart ({{ this.cartStore.itemNumber }})
                </router-link>
            </button>
            <page-nav-bar 
                v-if="isPagesNumberSuperiorToZero"
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
        <p>Oups! It seem that we can't fetch data. Try to reload the page </p>
    </div>
    <div v-else>
        <p>Loading data...</p>
    </div>
</template>

<style scoped>
    div{
        text-align: center;
    }
    .shop-container{
        flex-grow: 1;
        height: 100%;
        width: 100%;
        display: flex;
        flex-direction: column;
        justify-content: center;
        background-color: #F8F0E5;
    }
    .product-list-container{
        flex-grow: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
    }
    header{
        display: flex;
        flex-direction: column;
        align-items: center;
    }
    .cart-btn{
        float: right;
        width: 70px;
        align-self: flex-end;
        margin-top: 10px;
        margin-right: 10px;
    }
    .primary-btn{
        background-color: #B19A81;
        color: white;
        border: none;
        border-radius: 5px;
    }
    .primary-btn:hover{
        background-color: #8F857B;
    }
    a{
        text-decoration: none;
        color: white;
    }
    a:hover{
        color: white;
    }
</style>