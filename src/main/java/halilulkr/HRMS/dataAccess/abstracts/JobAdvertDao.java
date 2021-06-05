package halilulkr.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import halilulkr.HRMS.entities.concretes.JobAdvert;
import halilulkr.HRMS.entities.dtos.JobAdvertForListDto;

//incele

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer>{

	@Query("SELECT new halilulkr.HRMS.entities.dtos.JobAdvertForListDto(e.companyName,p.title,j.numberOfOpenPositions,j.createdAt,j.applicationDeadline) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p WHERE j.isActive=:isActive AND e.companyName=:companyName")
	List<JobAdvertForListDto> findAllByIsActiveAndEmployer_CompanyNameForList(@Param("isActive") boolean isActive,
			@Param("companyName") String companyName);

	@Query("SELECT new halilulkr.HRMS.entities.dtos.JobAdvertForListDto(e.companyName,p.title,j.numberOfOpenPositions,j.createdAt,j.applicationDeadline) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p WHERE j.isActive=:isActive")
	List<JobAdvertForListDto> findAllByIsActiveForList(@Param("isActive") boolean isActive);

	@Query("SELECT new halilulkr.HRMS.entities.dtos.JobAdvertForListDto(e.companyName,p.title,j.numberOfOpenPositions,j.createdAt,j.applicationDeadline) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p WHERE j.isActive=:isActive ORDER BY j.createdAt DESC")
	List<JobAdvertForListDto> findAllByIsActiveOrderByCreatedAtDescForList(@Param("isActive") boolean isActive);

	@Query("SELECT new halilulkr.HRMS.entities.dtos.JobAdvertForListDto(e.companyName,p.title,j.numberOfOpenPositions,j.createdAt,j.applicationDeadline) FROM JobAdvert j JOIN j.employer e JOIN j.jobPosition p WHERE j.isActive=:isActive ORDER BY j.createdAt")
	List<JobAdvertForListDto> findAllByIsActiveOrderByCreatedAtForList(@Param("isActive") boolean isActive);
}
