<template>
    <header>
        <router-link :to="{name: 'home'}">
            <img alt="logo" src="@/assets/logo.png" />
        </router-link>
        
    </header>
</template>

<style scoped>
    header{
        height: 64px;
        background-color: #956B4B;
    }
    img {
        height: 90%;
        margin: 2px;
    }
</style>