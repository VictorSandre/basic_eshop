<script>
import AppHeader from '@/components/global/AppHeader.vue'

export default {
  name: 'App',
  components: {
    AppHeader
  }
}
</script>

<template>
    <app-header/>
    <main class="main-layout">
        <router-view></router-view>
    </main>
    <footer class="app-footer">Vict Sand</footer>
</template>

<style lang="scss">
@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700;900&display=swap');
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';

.layout{
    @include block-size(100%100%);
}
body{
    margin: 0;
    padding: 0;
    font-family: 'Roboto', sans-serif;
}
#app{
    min-height: 100vh;
    @include flex-display(column);
}
.main-layout{
    background-color: $third-color;
    flex-grow: 1;
    margin: 0 10px 10px 10px;
    @include flex-display(column, center, center);
}
.app-footer{
    min-height: 60px;
    width:100%;
    text-align: center;
    margin-top: auto;
    background-color: $secondary-color;
    @include flex-display(row, center, center);
    color: $primary-color;
}
a{
    text-decoration: none;
    color: $primary-color;
}
</style>
