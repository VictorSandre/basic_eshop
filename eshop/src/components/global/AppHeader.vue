<template>
    <header>
        <router-link :to="{name: 'home'}">
            <img alt="logo" src="@/assets/logo.png" />
        </router-link>
        <app-nav/>
    </header>
</template>

<script>
import AppNav from '@/components/global/AppNav.vue'

export default {
  components: {
    AppNav
  }
}
</script>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';

header{
    height: 64px;
    background-color: $fourth-color;
    display: flex;
    position: sticky;
    top: 0;
    z-index: 1000;
}
img {
    height: 90%;
    margin: 2px;
}
a{
    width: 64px;
}
</style>
