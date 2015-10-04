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
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import authorization.dto.AuthorizationDTO;
import authorization.entity.Authorization;
import authorization.entity.Subject;
import authorization.repository.AuthorizationRepository;
import authorization.repository.SubjectRepository;

@Component
@Path("/authorization")
public class AuthorizationResourse {

  @Autowired
  private AuthorizationRepository authorizationRepository;
  @Autowired
  private SubjectRepository subjectRepository;

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

    List<Subject> subjects = subjectRepository.findByFirstName(firstName);
    List<Long> ids = new ArrayList<>();
    for (Subject subject : subjects) {
      ids.add(subject.getId());
    }

    List<AuthorizationDTO> list = new ArrayList<>();
    for (Authorization authorization : authorizationRepository.findAll(ids)) {
      AuthorizationDTO dto = new AuthorizationDTO();
      dto.fromDomain(authorization);
      list.add(dto);
    }
    return list;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(AuthorizationDTO dto) {

  }
}
