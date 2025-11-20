# REST Web Practice
***
### Continue working on Spring MVC. Implement the following functionality.

- OrderController
    - Complete order - POST: /orders/complete?userId
    - Get orders history for user - GET: /orders?userId
- AuthenticationController
    - Register - POST: /register 
- UserController
    - Get user by email - GET: /users/by-email?email
- ShoppingCartController
    - Add movie session - PUT: /shopping-carts/movie-sessions?userId&movieSessionId
    - Get by user - GET: /shopping-carts/by-user?userId

We will remove `userId` from request parameters in the future.

_! Don't create GlobalExceptionHandler, custom validation annotations in this HW (this is not specified in the task condition)_

**You can check yourself using this [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-spring/rest-practice/jv-spring-rest-practice_checklist)**
