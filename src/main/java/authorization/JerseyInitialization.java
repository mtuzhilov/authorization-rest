package authorization;

import org.glassfish.jersey.server.ResourceConfig;

public class JerseyInitialization extends ResourceConfig {
  /**
   * Register JAX-RS application components.
   */
  public JerseyInitialization(){
      this.packages("authorization");
  }
}