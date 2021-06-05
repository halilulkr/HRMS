package halilulkr.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.JobSeekerCVExperience;

public interface JobSeekerCVExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer>{

	List<JobSeekerCVExperience> findAllByJobSeekerCV_Id(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId);

	List<JobSeekerCVExperience> findAllByJobSeekerCV_IdOrderByQuitDateDesc(int jobSeekerCVId);
}
