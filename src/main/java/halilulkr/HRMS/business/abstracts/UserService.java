package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.entities.User;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;

public interface UserService extends BaseService<User, Integer> {
	DataResult<User> getByEmail(String email);

	Result isNotEmailExist(final String email);
}
