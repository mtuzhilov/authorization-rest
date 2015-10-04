package authorization.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import authorization.entity.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Long> {

  List<Subject> findByLastName(String lastName);
}
