package halilulkr.HRMS.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.Language;

public interface LanguageDao extends JpaRepository<Language, String>{

}
