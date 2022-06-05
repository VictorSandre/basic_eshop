<template>
  <nav>
  <ul>
    <li>
      <router-link :to="{name: 'shop'}">Shop</router-link>
    </li>
    <li>
      <a href="#">About</a>
      <ul class="sub-menu">
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
          <router-link :to="{name: 'about'}">About the project</router-link>
        </li>
      </ul>
    </li>
  </ul>
</nav>
</template>

<style scoped>
nav{
    width: 100%;
    background-color: white;
    position: sticky;
    top: 0px;
    margin: 10px 10px 5px 10px;
}

nav ul{
    list-style-type: none;
    display: flex;
    flex-direction: row;
    justify-content: center;
    margin: 0;
    padding-left: 0;
}

nav ul li{
    width: 25%;
    text-align: center;
}

  nav a{
      display: block;
      text-decoration: none;
      color: black;
      border-bottom: 3px solid transparent;
      padding-bottom: 5px;
  }

  nav a:hover{
      color: #016328;
      border-bottom: 3px solid #016328;
  }

  .sub-menu{
      display: none;
      box-shadow: 0px 1px 2px #CCC;
      background-color: white;
      position: absolute;
      width: 100%;
      z-index: 1000;
      padding: 0;
  }
  nav > ul li:hover .sub-menu{
      display: flex;
      flex-direction: column;
      width: 25%;
  }
  .sub-menu li{
      width: 100%;
      text-align: left;
  }
  .sub-menu a{
      padding: 10px;
      border-bottom: none;
  }
  .sub-menu a:hover{
      border-bottom: none;
      background-color: RGBa(200,200,200,0.1);
  }
</style>