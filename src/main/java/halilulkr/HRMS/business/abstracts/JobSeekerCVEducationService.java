package halilulkr.HRMS.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCVEducation;


public interface JobSeekerCVEducationService extends BaseService<JobSeekerCVEducation, Integer> {
	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVEducation>> getAllByJobSeekerCV_IdOrderByGraduationDate(int jobSeekerCVId,
			Direction direction);
}
