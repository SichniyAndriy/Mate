# Spring security

1. Configure Spring Security with in memory authentication.
1. Replace all `?userId` @RequestParam in your code with Authentication object.
1. Add @NonNull, @Min, etc annotations where applicable
   (add [this dependency](https://mvnrepository.com/artifact/org.hibernate/hibernate-validator)
   to your project, see example [here](https://hibernate.org/validator/))
1. Implement custom email validation.
1. Implement CustomGlobalExceptionHandler.
1. Remove method `login()` in AuthenticationService, `HashUtil` and `salt` from User entity.
   Start using `passwordEncoder` in UserService -> add() for password hashing.
   
*IMPORTANT:*
For dependency `hibernate-validator` don't use version `7.0.0.Final` and higher, they are not 
fully compatible with Spring now, and may not work properly. You can use `6.1.6.Final`;

Advanced:
1. In the UserRequestDto add a `repeatPassword` field.
1. Implement validation to check that password and repeatPassword are the same.
1. In your CustomGlobalExceptionHandler, return JSON response with HTTP status 500
   if `DataProcessingException` is thrown.
   
__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-spring/security/jv-spring-security-checklist)
