package halilulkr.HRMS.business.abstracts;

import java.util.List;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCVLanguage;

public interface JobSeekerCVLanguageService extends BaseService<JobSeekerCVLanguage, Integer> {
	DataResult<List<JobSeekerCVLanguage>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
