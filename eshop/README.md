# Eshop::Frontend

## Project setup :

In order to run the project, you need to [install npm](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm) on you're computer.

## Compiles and hot-reloads for development :
In  `./eshop/` directory
```bash
npm install
npm run serve
```
:warning: Default port is 8080 but you can change it with option
```bash
npm run serve -- --port 8056
```

## Compiles and minifies for production :
```bash
npm run build
```

### Customize configuration :
See [Configuration Reference](https://cli.vuejs.org/config/).

## Structure of the project

```
.
├── babel.config.js
├── jsconfig.json
├── package.json
├── package-lock.json
├── public
│   ├── favicon.ico
│   └── index.html
├── README.md
├── src
│   ├── App.vue
│   ├── assets
│   │   ├── img_not_found.png
│   │   └── logo.png
│   ├── components
│   │   ├── AboutView.vue
│   │   ├── error
│   │   │   └── PageNotFound.vue
│   │   ├── global
│   │   │   ├── AppHeader.vue
│   │   │   ├── AppNav.vue
│   │   │   └── LoadingComponent.vue
│   │   └── shop
│   │       ├── cart
│   │       │   └── CartView.vue
│   │       ├── ProductItem.vue
│   │       ├── ProductList.vue
│   │       ├── ProductNav.vue
│   │       └── ShopView.vue
│   ├── main.js
│   ├── router
│   │   └── index.js
│   ├── scss
│   │   └── utils
│   │       ├── _mixins.scss
│   │       └── _variables.scss
│   └── stores
│       └── CartStore.js
└── vue.config.js
```