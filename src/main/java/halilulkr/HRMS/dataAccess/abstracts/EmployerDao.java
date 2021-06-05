package halilulkr.HRMS.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{

	Optional<Employer> findByCorporateEmail(String corporateEmail);
}
