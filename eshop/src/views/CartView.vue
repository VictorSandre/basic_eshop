<script>
import { useCartStore } from '../stores/CartStore'

export default {
    setup() {
        const cartStore = useCartStore()
        
        return {
            cartStore,
        };
    },
}
</script>

<template>
    <div v-if="this.cartStore.productsMap.size !== 0">
        <h2>total price : {{ this.cartStore.totalPrice }} €</h2>
        <div class="item-list">
            <div class="item" v-for="item in this.cartStore.productsMap.values()" :key="item.id">
                    <img :src="item.product.image" :alt="item.product.title" @error="$event.target.src=require('@/assets/img_not_found.png')">
                    <h3>{{ item.product.title }}</h3>
                    <h3>{{ item.product.price }} €</h3>
                    <h3>Quantity : {{ item.nb }}</h3>
                <button @click="this.cartStore.removeProduct(item.product)">Remove</button>
            </div>
        </div>
    </div>
    <div v-else>
        <h1>The cart is empty</h1>
        <router-link :to="{name: 'shop'}">Go back to the shop</router-link>
    </div>
    
</template>

<style scoped>
    img{
        max-height: 100px;
        max-width: 100px;
    }
    div{
        text-align: center;
    }
    button{
        background-color: brown;
        color: white;
        border: 0;
        border-radius: 5px;
    }
    .item{
        background-color: white;
        margin: 10px;
        min-width: 200px;
        border-radius: 10px;
    }
</style>