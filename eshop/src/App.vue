<script>
import AppHeader from '@/components/AppHeader.vue'
import AppNavBar from '@/components/AppNavBar.vue'

export default {
  name: 'App',
  components: {
    AppHeader,
    AppNavBar
  }
}
</script>

<template>
    <app-header></app-header>
    <app-nav-bar></app-nav-bar>
    <main class="main-layout">
        <router-view></router-view>
    </main>
    <footer class="app-footer">VicSan's project</footer>
</template>

<style>
.layout{
    height: 100%;
    width: 100%;
    
}
    body{
        margin: 0;
        padding: 0;
    }
    #app{
        min-height: 100vh;
        display: flex;
        flex-direction: column;
    }
    .main-layout{
        background-color: #F8F0E5;
        flex-grow: 1;
        margin: 0 10px 10px 10px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
    }
    .app-footer{
        min-height: 60px;
        text-align: center;
        margin-top: auto;
        background-color: #E2C7AA;
        display: flex;
        justify-content: center;
        align-items: center;
        width:100%;
    }
    a{
        text-decoration: none;
        color: #016328;
    }
</style>
