<script>

export default {
  data () {
    return {
      mobileNavOrBarNav: String,
      isMobileMenuOpen: false
    }
  },
  computed: {
    showMenu () {
      if (this.isMobileMenuOpen && this.isMobileScreen()) {
        return 'appear'
      } else {
        return ' '
      }
    }
  },
  methods: {
    isMobileScreen () {
      if (window.innerWidth <= 750) {
        this.mobileNavOrBarNav = 'mobile-nav'
        return true
      } else {
        this.mobileNavOrBarNav = 'bar-nav'
        this.isMobileMenuOpen = false
        return false
      }
    },
    toggleMenuButton () {
      this.isMobileMenuOpen = !this.isMobileMenuOpen
    }
  },
  created () {
    this.isMobileScreen()
    window.addEventListener('resize', this.isMobileScreen)
  }
}
</script>

<template>
  <nav :class="mobileNavOrBarNav">
    <div class="icon" v-if="this.mobileNavOrBarNav == 'mobile-nav'" @click="this.toggleMenuButton">
      <div class="burger-line"/>
      <div class="burger-line"/>
      <div class="burger-line"/>
    </div>
    <ul :class="showMenu">
      <li>
        <router-link :to="{name: 'shop'}" @click="toggleMenuButton">Shop</router-link>
      </li>
      <li>
        <a href="https://github.com/VictorSandre" target="_blank" rel="noopener noreferrer">
          Github page
        </a>
      </li>
      <li>
        <a href="https://www.linkedin.com/in/victor-sandre-08b75b157/" target="_blank" rel="noopener noreferrer">
          Linkedin page
        </a>
      </li>
      <li>
        <router-link :to="{name: 'about'}" @click="toggleMenuButton">About the project</router-link>
      </li>
    </ul>
</nav>
</template>

<style scoped lang="scss">
@import '@/scss/utils/_variables.scss';
@import '@/scss/utils/_mixins.scss';

.bar-nav{
width: 100%;
padding-right: 10%;
@include flex-display(row, flex-end);
ul{
  @include flex-display(row, flex-end);
  padding-left: 0;
  list-style-type: none;
}
li {
  margin: auto 10px;
}
a {
  color: white;
  &:hover {
    color: $primary-color;
    transition: 0.5s ease all;
  }
}
}
.mobile-nav{
width: 100%;
padding-right: 10%;
@include flex-display(column, flex-end);
ul{
  @include flex-display(column, flex-start);
  padding-left: 0px;
  padding-top: 60px;
  margin: 0;
  list-style-type: none;
  background-color: white;
  position: absolute;
  left: -310px;
  top: 0;
  @include block-size(250px, 100vh);
  box-shadow: -10px 0 50px rgba(0,0,0,0.2);
  transition: 1s;
}
li{
  color: $primary-color;
  padding: 15px 10px 15px  10px;
  transition: 0.2s;
  &:active {
    background-color: lightgrey;
  }
}
}
.appear{
transform: translateX(310px);
}
.icon{
@include block-size(35px, 35px);
@include flex-display(column, center);
margin: auto 0 auto auto ;
background-color: white;
border: 1px lightgray solid;
border-radius: 10px;
z-index: 500;
&:after {
  content: "";
  display: block;
  position: absolute;
  border-radius: 10px;
  right: 10vw;
  top: 20px;
  @include block-size(35px, 35px);
  opacity: 0;
  transition: all 1s;
  box-shadow: 0 0 10px 40px white;
}
&:active {
  top: 1px;
}
&:active:after {
  box-shadow: 0 0 0 0 white;
  position: absolute;
  border-radius: 10px;
  left: 0;
  top:15px;
  opacity: 1;
  transition: 0s;
}
.burger-line{
  margin: 1px 10px;
  border-top: 4px black solid;
}
}
</style>
