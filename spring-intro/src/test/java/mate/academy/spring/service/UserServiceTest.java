package mate.academy.spring.service;

import static org.junit.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import mate.academy.spring.config.TestAppConfig;
import mate.academy.spring.model.User;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestAppConfig.class)
@TestPropertySource(locations="classpath:application.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserServiceTest {
  private static UserService userService;

  @BeforeClass
  public static void setUp() {
    AnnotationConfigApplicationContext context =
        new AnnotationConfigApplicationContext(TestAppConfig.class);
    userService = context.getBean(UserService.class);
  }

  @Test
  public void getAll_NoUsers_Ok() {
    List<User> expected = Collections.emptyList();
    List<User> actual = userService.getAll();
    assertEquals(expected, actual);
  }

  @Test
  public void getAll_WithUsers_Ok() {
    User john = createUser("John", 18);
    User ann = createUser("Ann", 20);
    List<User> expected = List.of(john, ann);
    List<User> actual = userService.getAll();
    assertEquals(expected, actual);
  }

  private User createUser(String name, int age) {
    User user = new User();
    user.setName(name);
    user.setAge(age);
    return userService.add(user);
  }
}
