<script>
import { useCartStore } from '@/stores/CartStore'

export default {
  setup () {
    const cartStore = useCartStore()

    return {
      cartStore
    }
  }
}
</script>

<template>
    <div class="cart-store" v-if="this.cartStore.productsMap.size !== 0">
        <h2>total price : {{ this.cartStore.totalPrice }} €</h2>
        <div class="item-list">
            <div class="item" v-for="item in this.cartStore.productsMap.values()" :key="item.id">
                    <img :src="item.product.image" :alt="item.product.title" @error="$event.target.src=require('@/assets/img_not_found.png')">
                    <h3>{{ item.product.title }}</h3>
                    <h3>{{ item.product.price }} €</h3>
                    <div class="quantity">
                        <button class="add" @click="this.cartStore.addProduct(item.product)"> + </button>
                        <h3>{{ item.nb }}</h3>
                        <button class="remove" @click="this.cartStore.removeProduct(item.product)"> - </button>
                    </div>
            </div>
        </div>
    </div>
    <div v-else>
        <h1>The cart is empty</h1>
        <router-link :to="{name: 'shop'}">Go back to the shop</router-link>
    </div>

</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';
div {
    text-align: center;
}
.quantity{
    display: flex;
    flex-direction: row;
    background-color: lightgrey;
    padding: 0;
    border-radius: 5px;
    margin: auto;
    .add {
        background-color: #016328;
    }
    .remove {
        background-color: brown;
    }
}
.item{
    background-color: white;
    margin: 10px;
    @include flex-display(column, center, center);
    @include block-size(90%, auto, none, none, 200px, 250px);
    border-radius: 10px;
    img {
        max-height: 100px;
        max-width: 100px;
        margin: auto;
    }
    h3 {
        margin: auto 25px auto 25px;
    }
    button{
        color: white;
        border: 0;
        border-radius: 5px;
        padding: 5px;
        margin: 0;
        min-width: 25px;
    }
}
.item-list,
.cart-store {
    width: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
@media only screen and (min-width: 750px){
    .item{
        flex-direction: row;
    }
}
</style>
