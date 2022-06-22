<script>
import { useCartStore } from '../../stores/CartStore'

export default {
  name: 'ProductItem',
  props: {
    id: null,
    image: String,
    title: String,
    price: Number
  },
  setup () {
    const cartStore = useCartStore()
    return { cartStore }
  }
}
</script>
<template>
    <div class="product">
        <img :src="image" :alt="title" @error="$event.target.src=require('@/assets/img_not_found.png')"/>
        <div class="shader">
            <h3> {{ title }} </h3>
            <button @click="this.cartStore.addProduct({id,image,title,price})">
                {{ price }} €
            </button>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';

.product{
    @include block-size(100%, 70vh, none, none, 180px, 300px);
    margin: 10px;
    position: relative;
}
img {
    object-fit: cover;
    @include block-size(100%, 100%);
}
.shader{
    @include block-size(100%, 100%);
    background: linear-gradient(hsla(0, 0%, 83%, 0) 80%, hsla(0, 0%, 0%, 1)),
                linear-gradient(-90deg ,hsla(0, 0%, 0, 0)60%, hsla(0, 0%, 0%, 1));
    position: absolute;
    bottom: 0;
    left: 0;
    @include flex-display(column);
}
h3{
    writing-mode: vertical-lr;
    transform: rotate(180deg) translate(90%);
    padding-top: 10px;
    text-align: left;
    position: absolute;
    bottom: 5%;
    left: 5%;
    color: white;
    padding: 0;
    text-transform: capitalize;
    font-size: 2.5em;
}
button{
    position: absolute;
    bottom: 5%;
    right: 5%;
    padding: 0.3em 0.8em;
    font-size: inherit;
    color: white;
    background-color: $primary-color;
    border: none;
    border-radius: 25px;
    &:active {
        transition: 0.2s all;
        transform: scale(0.80)
    }
}

@media only screen and (min-width: 750px){
.product{
    font-size: 1.5em;
    max-width: 400px;
    max-height: 500px;
    transition: all 0.5s ease;
    box-shadow: -10px 10px 55px -12px rgba(0,0,0,0.7);
    &:hover {
        transform: translateY(-15px);
    }
}
button {
    &:hover {
        background-color: lighten($primary-color, 10%);
        transition: 0.5s ease all;
    }
}
}
</style>
