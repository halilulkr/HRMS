package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.entities.User;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.EmailActivation;
import halilulkr.HRMS.entities.dtos.EmailActivationForVerifyDto;

public interface EmailActivationService extends BaseService<EmailActivation, Integer>{

	Result createAndSendActivationCodeByMail(User user, String... emails);

	Result verify(EmailActivationForVerifyDto emailActivationForVerifyDto);
}
