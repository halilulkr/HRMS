package halilulkr.HRMS.business.abstracts;

import java.util.List;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobAdvert;
import halilulkr.HRMS.entities.dtos.JobAdvertForListDto;

public interface JobAdvertService extends BaseService<JobAdvert, Integer> {
	Result disableById(int id);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveAndEmployer_CompanyNameForList(boolean isActive,
			String companyName);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveForList(boolean isActive);

	DataResult<List<JobAdvertForListDto>> getAllByIsActiveOrderByCreatedAtByForList(boolean isActive, String sort);
}
