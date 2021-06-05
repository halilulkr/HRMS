package halilulkr.HRMS.business.abstracts;

import java.util.List;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCVWebSite;


public interface JobSeekerCVWebSiteService extends BaseService<JobSeekerCVWebSite, Integer> {
	DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
