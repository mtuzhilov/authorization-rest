package authorization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import authorization.entity.Authorization;

@Repository
public interface AuthorizationRepository extends CrudRepository<Authorization, Long> {

}
