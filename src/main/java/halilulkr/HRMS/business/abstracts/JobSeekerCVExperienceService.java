package halilulkr.HRMS.business.abstracts;

import java.util.List;

import org.springframework.data.domain.Sort.Direction;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCVExperience;


public interface JobSeekerCVExperienceService extends BaseService<JobSeekerCVExperience, Integer> {
	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(int jobSeekerCVId);

	DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(int jobSeekerCVId,
			Direction direction);
}
