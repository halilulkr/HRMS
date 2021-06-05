package halilulkr.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.JobSeekerCVSkill;

public interface JobSeekerCVSkillDao extends JpaRepository<JobSeekerCVSkill, Integer>{

	List<JobSeekerCVSkill> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
