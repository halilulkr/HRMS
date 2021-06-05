package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobPosition;

public interface JobPositionService extends BaseService<JobPosition, Integer> {
	Result isNotExistsJobPosition(final String title);
}
