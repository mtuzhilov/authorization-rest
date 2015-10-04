package authorization;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import authorization.dto.AuthorizationDTO;

@Path("/authorization")
public class AuthorizationResourse {

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AuthorizationDTO create(AuthorizationDTO dto) {

    return null;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public AuthorizationDTO get() {
    AuthorizationDTO dto = new AuthorizationDTO();
    dto.setTest("asdfasdf");
    return dto;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(AuthorizationDTO dto) {

  }
}
