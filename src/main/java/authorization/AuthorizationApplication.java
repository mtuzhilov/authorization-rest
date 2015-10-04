package authorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.WebApplicationInitializer;

@EnableTransactionManagement
@SpringBootApplication
public class AuthorizationApplication extends SpringBootServletInitializer implements WebApplicationInitializer{


  public static void main(String[] args) {
    SpringApplication.run(AuthorizationApplication.class, args);
  }
}
