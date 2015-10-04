package authorization;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import authorization.dto.AuthorizationDTO;
import authorization.dto.SubjectDTO;
import authorization.entity.Subject;
import authorization.repository.SubjectRepository;

@Component
@Path("/authorization")
public class AuthorizationResourse {

  @Autowired
  private SubjectRepository subjectRepository;

  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public AuthorizationDTO create(AuthorizationDTO dto) {

    return null;
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<AuthorizationDTO> getAll() {

    List<AuthorizationDTO> list = new ArrayList<>();
    for (Subject subject : subjectRepository.findAll()) {
      AuthorizationDTO dto = new AuthorizationDTO();
      dto.setSubject(new SubjectDTO(subject));
      list.add(dto);
    }
    return list;
  }

  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  public void update(AuthorizationDTO dto) {

  }
}
