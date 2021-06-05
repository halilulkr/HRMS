package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.dtos.EmployerForRegisterDto;
import halilulkr.HRMS.entities.concretes.Employer;

public interface EmployerService extends BaseService<Employer, Integer>{

	Result isNotCorporateEmailExist(final String corporateEmail);

	Result register(EmployerForRegisterDto employerForRegister);
}
