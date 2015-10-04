package authorization.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import authorization.entity.PhoneNumber;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, Long> {

}
