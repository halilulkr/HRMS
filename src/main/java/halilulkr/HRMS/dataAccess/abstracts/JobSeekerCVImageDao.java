package halilulkr.HRMS.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import halilulkr.HRMS.entities.concretes.JobSeekerCVImage;

public interface JobSeekerCVImageDao extends JpaRepository<JobSeekerCVImage, Integer>{

	List<JobSeekerCVImage> findAllByJobSeekerCV_Id(int jobSeekerCVId);
}
