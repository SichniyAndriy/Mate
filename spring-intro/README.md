# Spring Framework intro


- Add all needed dependencies. Adding Spring dependencies use the same version for each of them. 
For this purpose you can use property `spring.version`. See example in `<artifactId>spring-test</artifactId>` dependency.

- Implement UserService and UserDao
  
    ```java
      public interface UserService {
          User add(User user);
      
          List<User> getAll();
      }
    ```
  
- User should have `age`, `name` fields and overridden `equals()` and `hashcode()` methods

- In the Main class configure ApplicationContext and show how you are saving User into DB and
  reading him back

- Configure DataSource

- Understand the main concepts of Spring framework:
    - ApplicationContext
    - Bean
    - Bean Autowiring
    - Difference between @Bean and @Autowired and @Qualifier
    - What does each annotation used in videos mean?

__You can check yourself using this__ [checklist](https://mate-academy.github.io/jv-program-common-mistakes/java-spring/intro/java-spring-intro)
