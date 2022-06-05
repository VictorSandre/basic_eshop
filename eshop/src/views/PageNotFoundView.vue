<template>
    <div class="container">
        <h1>404</h1>
        <h3> Oups ! It seem that the page you were looking for Does not exist </h3>
        <router-link :to="{name: 'home'}">Let's go back to home page</router-link>
    </div>
</template>

<style scoped>
    .container{
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
        height: 60vh;
    }
    h1{
        font-size: 200px;
        margin: 0;
    }
    h3{
        font-weight: bold;
        text-align: center;
    }
</style>