package authorization.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import authorization.entity.Authorization;

@Repository
public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {
  List<Authorization> findBySubjectFirstName(String firstName);
}
