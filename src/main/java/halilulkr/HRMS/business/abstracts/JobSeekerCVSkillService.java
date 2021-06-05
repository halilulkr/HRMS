package halilulkr.HRMS.business.abstracts;

import java.util.List;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.JobSeekerCVSkill;


public interface JobSeekerCVSkillService extends BaseService<JobSeekerCVSkill, Integer> {
	DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(int jobSeekerCVId);
}
