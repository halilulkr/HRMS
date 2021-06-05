package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobSeeker;
import halilulkr.HRMS.entities.dtos.JobSeekerForRegisterDto;

public interface JobSeekerService extends BaseService<JobSeeker, Integer> {
	DataResult<JobSeeker> getByIdentityNumber(String identityNumber);

	Result isNotNationalIdentityExist(String identityNumber);

	Result register(JobSeekerForRegisterDto jobSeekerForRegisterDto);
}
