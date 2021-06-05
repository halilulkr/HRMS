package halilulkr.HRMS.core.utilities.helpers.email;

import org.springframework.stereotype.Service;

import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessResult;

@Service
public class EmailManager implements EmailService{

	@Override
	public Result send(final String to, final String title, final String body) {
	
		return new SuccessResult("Email gönderildi.");
	}

}
