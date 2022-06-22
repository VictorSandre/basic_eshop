<script>
export default {
  name: 'PageNavBar',
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
    isLastPageNull () {
      return (this.lastPage === null)
    },
    isCurrentPageLast () {
      return (this.currentPage === this.lastPage)
    },
    isCurrentPageFirst () {
      return (this.currentPage === this.firstPage)
    },
    previousPage () {
      return this.currentPage - 1
    },
    nextPage () {
      return this.currentPage + 1
    }
  },
  methods: {
    updateProductList (pageNumberToGo) {
      this.$emit('change-page-data', pageNumberToGo)
    }
  }
}
</script>

<template>
    <div class="shop-nav">
        <div v-if="(!isCurrentPageFirst)">
            <button class="reverse-btn" @click="updateProductList(firstPage)">
                {{ firstPage + 1 }}
            </button>
            <button class="reverse-btn" @click="updateProductList(previousPage)" v-if="(currentPage > (firstPage + 1))">
                {{ previousPage + 1 }}
            </button>
        </div>

        <button class="current-btn">
            {{ currentPage + 1 }}
        </button>

        <div v-if="(!isLastPageNull && ! isCurrentPageLast)">
            <button class="reverse-btn" @click="updateProductList(nextPage)" v-if="(nextPage < lastPage)">
                {{ nextPage + 1}}
            </button>
            <button class="reverse-btn" @click="updateProductList(lastPage)">
                {{ lastPage + 1}}
            </button>
        </div>
    </div>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';

div {
  @include flex-display(row, center);
}
.shop-nav{
    margin: 10px 0;
}
.reverse-btn{
    border-radius: 5px;
    background-color: white;
    border: 1px solid white;
    margin: 3px;
    &:hover {
      background-color: white;
      border: 1px solid $primary-color;
      color: $primary-color;
      transition: all 1s ease;
  }
}
.current-btn{
    margin: 3px;
    padding: 5px 10px;
    background-color: $primary-color;
    color: white;
    border: none;
    border-radius: 5px;
}
.current-btn:hover{
    background-color: $primary-color;
}
@media only screen and (min-width: 780px){
      button {
      font-size: 1em;
  }
}
</style>
