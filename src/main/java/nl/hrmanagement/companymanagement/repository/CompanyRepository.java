package nl.hrmanagement.companymanagement.repository;

import nl.hrmanagement.companymanagement.model.Company;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.QueryHint;
import java.util.List;
import java.util.UUID;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Integer> {

    @QueryHints(@QueryHint(name= org.hibernate.annotations.QueryHints.CACHEABLE, value="true"))
    Company findById(int id);

    Company findByUuid(UUID id);

    List<Company> findAllByArchivedFalse();
    List<Company> findAllByArchivedTrue();
}
