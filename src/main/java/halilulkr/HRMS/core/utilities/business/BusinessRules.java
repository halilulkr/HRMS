package halilulkr.HRMS.core.utilities.business;

import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result run(final Result... logics) {
		for (final Result logic : logics) {
			if(!logic.isSuccess()) {
				return logic;
			}
		}
		return new SuccessResult();
	}
}
