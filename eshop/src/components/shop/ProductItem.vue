<script>
import { useCartStore } from '../../stores/CartStore'

export default {
    name: "ProductItem",
    props: {
        id: null,
        image: String,
        title: String,
        price: Number
    },
    setup(){
        const cartStore = useCartStore()
        return { cartStore }
    }
}
</script>
<template>
    <div class="product">
        <div class="item-img">
            <img :src="image" :alt="title" @error="$event.target.src=require('@/assets/img_not_found.png')"/>
        </div>
        
        <div>
            <div>
                <h2> {{ title }} </h2>
                <h3> {{ price }} €</h3>
            </div>
            <button class="primary-btn" @click="this.cartStore.addProduct({id,image,title,price})">Add</button>
        </div>
    </div>
</template>

<style scoped>
    .product{
        background-color: white;
        min-width: 200px;
        min-height: 400px;
        width: 25%;
        height: 20vh;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        text-align: center;
        margin: 20px;
        border-radius: 10px;
    }
    .item-img {
        min-width: 200px;
        min-height: 200px;
        max-height: 50%;
        max-width: 80%;
        padding: 5px;
        display: flex;
        justify-content: center;
        align-items: center;
    }
    .item-img img{
        height: auto;
        width: auto;
        max-width: 100%;
        max-height: 100%;
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
</style>