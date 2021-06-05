package halilulkr.HRMS.core.utilities.helpers.email;

import halilulkr.HRMS.core.utilities.results.Result;

public interface EmailService {

	Result send(String to, String title, String body);
}
