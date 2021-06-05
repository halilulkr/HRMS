package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCV;

public interface JobSeekerCVService extends BaseService<JobSeekerCV, Integer> {
	DataResult<JobSeekerCV> getByJobSeeker_Id(int jobSeekerId);
}
