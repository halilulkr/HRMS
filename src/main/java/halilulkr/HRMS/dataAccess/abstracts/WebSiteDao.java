package halilulkr.HRMS.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.WebSite;

public interface WebSiteDao extends JpaRepository<WebSite, Short>{

	Optional<WebSite> findByName(String name);
}
