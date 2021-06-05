package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.business.adapters.mernisService.PersonForValidateFromMernisService;
import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.MernisActivation;

public interface MernisActivationService extends BaseService<MernisActivation, Integer> {
	Result check(PersonForValidateFromMernisService personForValidateFromMernisService);
}