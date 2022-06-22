<template>
    <div class="loader"></div>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';

.loader {
  margin: auto;
  border: 20px solid $secondary-color;
  border-radius: 50%;
  border-top: 20px solid $primary-color;
  width: 150px;
  height: 150px;
  animation: spinner 3s linear infinite;
}

@keyframes spinner {
  0% { transform: rotate(0deg); }
  100% { transform: rotate(360deg); }
}
</style>
