import { defineStore } from "pinia";

export const useCartStore = defineStore("cartStore", {
    state: () => {
        return {
            productsMap: new Map()
        }
    },
    getters: {
        itemNumber() {
            let itemNumber = 0
            for (const value of this.productsMap.values()) {
                itemNumber += value.nb
            }
            return itemNumber
        },
        totalPrice() {
            let price = 0
            for (const value of this.productsMap.values()) {
                price += value.nb * value.product.price
            }
            return (Math.trunc(price *1000)/1000)
        }
    },
    actions: {
        addProduct(product) {
            if(this.productsMap.has(product.id)) {
                this.productsMap.get(product.id).nb++
            }
            else {
                this.productsMap.set(product.id, {product: product, nb: 1})
            }
        },
        removeProduct(product) {
            if(this.productsMap.has(product.id)) {
                if(this.productsMap.get(product.id).nb > 1) {
                    this.productsMap.get(product.id).nb--
                }
                else {
                    this.productsMap.delete(product.id)
                }
            }
            //else throw exception ?
        }
    }
})