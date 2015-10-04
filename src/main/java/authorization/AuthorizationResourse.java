package authorization;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import authorization.dto.AuthorizationDTO;
import authorization.entity.Authorization;
import authorization.repository.AuthorizationRepository;

@Component
@Transactional
@Path("/authorization")
public class AuthorizationResourse {

  @Autowired
  private AuthorizationRepository authorizationRepository;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AuthorizationDTO create(AuthorizationDTO dto) {
    Authorization authorization = authorizationRepository.save(dto.toDomain());
    AuthorizationDTO authorizationDTO = new AuthorizationDTO();
    authorizationDTO.fromDomain(authorization);
    return authorizationDTO;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<AuthorizationDTO> getAll() {
    List<AuthorizationDTO> list = new ArrayList<>();
    for (Authorization authorization : authorizationRepository.findAll()) {
      AuthorizationDTO dto = new AuthorizationDTO();
      dto.fromDomain(authorization);
      list.add(dto);
    }
    return list;
  }


  @GET
  @Path("/subject/{firstName}")
  @Produces(MediaType.APPLICATION_JSON)
  public List<AuthorizationDTO> getByName(@PathParam("firstName") String firstName) {

    List<AuthorizationDTO> list = new ArrayList<>();
    for (Authorization authorization : authorizationRepository.findBySubjectFirstName(firstName)) {
      AuthorizationDTO dto = new AuthorizationDTO();
      dto.fromDomain(authorization);
      list.add(dto);
    }
    return list;
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(@PathParam("id") Long id, AuthorizationDTO dto) {
    Authorization authorization = authorizationRepository.findOne(id);
    if (authorization == null) {
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    }
    authorizationRepository.delete(authorization);
    authorizationRepository.save(dto.toDomain());
  }
}
