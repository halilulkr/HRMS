package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.CompanyStaffVerification;

public interface CompanyStaffVerificationService extends BaseService<CompanyStaffVerification, Integer>{

	DataResult<CompanyStaffVerification> getByUserId(final int userId);
	
	Result verify(int id);
}
