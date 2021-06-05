package halilulkr.HRMS.dataAccess.abstracts;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.JobSeekerCV;

public interface JobSeekerCVDao extends JpaRepository<JobSeekerCV, Integer>{

	Optional<JobSeekerCV> findByJobSeeker_Id(int jobSeekerId);
}
