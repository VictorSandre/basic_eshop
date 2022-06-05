<script>
export default {
    name: "PageNavBar",
    props: {
        lastPage: {
            type: Number,
            default: 0,
            required: true
        },
        currentPage: {
            type: Number,
            default: 0,
            required: true
        },
        firstPage: {
            type: Number,
            default: 0,
            required: false
        }
    },
    computed: {
        isLastPageNull() {
            if (this.lastPage === null) {
                return true;
            }
            else {
                return false;
            }
        },
        isCurrentPageLast() {
            if (this.currentPage === this.lastPage) {
                return true;
            }
            else {
                return false;
            }
        },
        isCurrentPageFirst() {
            if (this.currentPage === this.firstPage) {
                return true;
            }
            else {
                return false;
            }
        },
        previousPage() {
            return this.currentPage - 1
        },
        nextPage() {
            return this.currentPage + 1
        }
    },
    methods: {
        updateProductList(pageNumberToGo) {
            this.$emit("change-page-data", pageNumberToGo)
        }
    }
}
</script>

<template>
    <div class="shop-nav">
        <div v-if="(!isCurrentPageFirst)">
            <button class="reverse-btn" @click="updateProductList(firstPage)"> 
                {{ firstPage }}
            </button>
            <button class="reverse-btn" @click="updateProductList(previousPage)" v-if="(currentPage > (firstPage + 1))"> 
                {{ previousPage }}
            </button>
        </div>

        <button class="current-btn"> 
            {{ currentPage }}
        </button>

        <div v-if="(!isLastPageNull && ! isCurrentPageLast)">
            <button class="reverse-btn" @click="updateProductList(nextPage)" v-if="(nextPage < lastPage)">
                {{ nextPage }}
            </button>
            <button class="reverse-btn" @click="updateProductList(lastPage)"> 
                {{ lastPage }}
            </button>
        </div>
    </div>
</template>

<style scoped>
    div {
        display: flex;
        justify-content: center;
    }
    .shop-nav{
        margin-bottom: 10px;
        margin-top: 10px;
    }
    .reverse-btn{
        padding-left: 8px;
        padding-right: 8px;
        padding-top: 5px;
        padding-bottom: 5px;
        border-radius: 5px;
        background-color: white;
        color: black;
        border: none;
        margin: 3px;
    }
    .reverse-btn:hover{
        background-color: white;
        color: #B19A81;
        border: 1px solid #B19A81;
        padding-left: 7px;
        padding-right: 7px;
        padding-top: 4px;
        padding-bottom: 4px;
    }
    .current-btn{
        margin: 3px;
        padding-left: 8px;
        padding-right: 8px;
        padding-top: 5px;
        padding-bottom: 5px;
        background-color: #B19A81;
        color: white;
        border: none;
        border-radius: 5px;
    }
    .current-btn:hover{
        background-color: #8F857B;
    }
</style>