<script>
import ProductItem from './ProductItem.vue'

export default {
    name: "ProductList",
    props: {
        products: Array
    },
    components: {
        ProductItem
    }
}
</script>

<template>
    <div class="product-list">
        <product-item 
            v-for="item in products" :key="item.id"
            :id="item.id"
            :title="item.title"
            :image="item.image"
            :price="item.price"/>
    </div>
</template>

<style scoped>
    .product-list {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around;
    }
</style>