<script>
export default {
  props: {
    message: {
      type: String,
      default: 'You\'re either misspelling the URL or requesting a page that\'s no longer here',
      required: false
    },
    linkMessage: {
      type: String,
      default: 'Let\'s go back to home page',
      required: false
    },
    routeNameRedirection: {
      type: String,
      default: 'home',
      required: false
    },
    isLinkPrinted: {
      type: Boolean,
      default: true,
      required: false
    }
  }
}
</script>

<template>
    <div class="container">
        <h3> Oups !</h3>
        <h1>404</h1>
        <h3> {{ message }} </h3>
        <router-link v-if="isLinkPrinted" :to="{name: '' + routeNameRedirection}">
            {{linkMessage }}
        </router-link>
    </div>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_mixins.scss';

.container{
    @include flex-display(column, center, center);
    position: relative;
    width: 65vw;
    margin: 20px;
    background: white;
    padding: 60px 40px;
    text-align: center;
    box-shadow: -10px 10px 67px -12px rgba(0,0,0,0.2);
}
h1{
    font-size: 4em;
    margin: 0;
}
h3{
    font-weight: bold;
    text-align: center;
}
</style>
