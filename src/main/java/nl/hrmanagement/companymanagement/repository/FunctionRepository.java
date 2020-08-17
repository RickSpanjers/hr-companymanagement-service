package nl.hrmanagement.companymanagement.repository;

import nl.hrmanagement.companymanagement.model.Function;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.UUID;

@Repository
public interface FunctionRepository extends CrudRepository<Function, Integer> {

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    Function findById(int id);

    Function findByUuid(UUID id);

    List<Function> findAllByCompanyId(int companyId);

    List<Function> findAllByCompanyUuid(UUID companyId);
}
