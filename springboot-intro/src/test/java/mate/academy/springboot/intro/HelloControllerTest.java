package mate.academy.springboot.intro;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.web.bind.annotation.GetMapping;

@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class HelloControllerTest {
  private static final String ENDPOINT = "/hello";
  private static final String EXPECTED_RESPONSE = "Hello, mates!";
  private static final int EXPECTED_PORT = 8083;
  @Autowired
  private MockMvc mockMvc;
  @Value("${server.port}")
  private int port;

  @Test
  public void controller_HasOneMethod_Ok() {
    int actual = HelloController.class.getDeclaredMethods().length;
    assertEquals(1, actual,
        "HelloController should have only one method");
  }

  @Test
  public void method_SignatureValid_Ok() {
    Method method = HelloController.class.getDeclaredMethods()[0];
    assertTrue(Modifier.isPublic(method.getModifiers()),
        "Method should be public");
    assertEquals(String.class, method.getReturnType(),
        "Return type of the method should be String");
    assertEquals(0, method.getParameters().length,
        "Method shouldn't have parameters");
    assertTrue(method.isAnnotationPresent(GetMapping.class),
        "Method should accept GET requests");
  }

  @Test
  public void controller_HasHelloEndpointWithValidResponse_Ok() throws Exception {
    MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get(ENDPOINT))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andReturn();
    String actual = mvcResult.getResponse().getContentAsString();
    assertEquals(EXPECTED_RESPONSE, actual);
  }

  @Test
  public void port_IsValid_Ok() {
    assertEquals(EXPECTED_PORT, port);
  }
}
