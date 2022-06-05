# Basic Eshop

## Goal of the project :
I haven't use Vuejs for one year so the goal of this project was to maintain a minimum of ease with this technologie.

## How to run the project

  - Run the backend server as [explained here](./products/README.md)

  - :warning: Actually you have to copy the adress of the backend api (for example: `localhost:8080/products`) and replace baseUrl value in [this file](./eshop/src/views/ShopView.vue) at line 47
  ```
  const baseUrl = 'http://192.168.1.25:8081/products'
  ```

  - Then run the front end server as [explaiend here](./eshop/README.md)

## Features to implement :
  - Add 1-2 screenshot and describe list functionalities in Readme 
### Frontend :
  - use env dev/prod var for backend API url for /products
  - caching management
  - betteren the CSS or use vuetify 3 when aviable
  - add css configuration for smartphone size
  - refractor code with typescript
  - tests
  - homepage
  - project description page

### Backend : 
  - 404 error (with haetos that give link to /products)
  - CRUD methods
  - test for servlets
  - remove h2 console

## Want to improve the code ?

You see an issue or you want to improve my code ? Then you are welcome to contact me :smile:
