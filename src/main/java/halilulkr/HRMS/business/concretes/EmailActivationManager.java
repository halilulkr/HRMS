package halilulkr.HRMS.business.concretes;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.EmailActivationService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.entities.User;
import halilulkr.HRMS.core.utilities.helpers.email.EmailService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.ErrorResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.EmailActivationDao;
import halilulkr.HRMS.entities.concretes.EmailActivation;
import halilulkr.HRMS.entities.dtos.EmailActivationForVerifyDto;

@Service
public class EmailActivationManager implements EmailActivationService{

	private final EmailActivationDao emailActivationDao;
	private final EmailService emailService;
	
	@Autowired
	public EmailActivationManager(EmailActivationDao emailActivationDao, EmailService emailService) {
		super();
		this.emailActivationDao = emailActivationDao;
		this.emailService = emailService;
	}

	@Override
	public Result add(final EmailActivation emailActivation) {
		this.emailActivationDao.save(emailActivation);
		return new SuccessResult(Messages.emailActivationAdded);
	}

	@Override
	public Result delete(final EmailActivation emailActivation) {
		emailActivationDao.delete(emailActivation);
        return new SuccessResult(Messages.emailActivationDeleted);
	}

	@Override
	public DataResult<List<EmailActivation>> getAll() {
		final List<EmailActivation> emailActivations = this.emailActivationDao.findAll();
		return new SuccessDataResult<List<EmailActivation>>(emailActivations);
	}

	@Override
	public DataResult<EmailActivation> getById(final Integer id) {
		final Optional<EmailActivation> emailActivation = this.emailActivationDao.findById(id);
		
		if(emailActivation.isEmpty()) {
			return new ErrorDataResult<EmailActivation>(Messages.emailActivationNotFound);
		}
		return new SuccessDataResult<EmailActivation>(emailActivation.get());
	}

	@Override
	public Result update(final EmailActivation emailActivation) {
		this.emailActivationDao.save(emailActivation);
		return new SuccessResult(Messages.emailActivationUpdated);
	}

	@Override
	public Result createAndSendActivationCodeByMail(final User user, final String... emails) {
		for(final String email : emails) {
			final EmailActivation emailActivation = EmailActivation.builder().user(user).
					email(email).activationCode("ActivationCode").
					expirationDate(LocalDateTime.now().
					plusMonths(1)).build();
			
			emailActivationDao.save(emailActivation);
			emailService.send(email, Messages.emailActivationVerifyEmailTitle, null); //incele
		}
		return new SuccessResult(Messages.emailActivationCreatedAndSent);
	}

	@Override
	public Result verify(final EmailActivationForVerifyDto emailActivationForVerifyDto) {
		final Optional<EmailActivation> emailActivation = emailActivationDao.findByEmailAndActivationCode(
				emailActivationForVerifyDto.getEmail(),
				emailActivationForVerifyDto.getActivationCode());

		if (emailActivation.isEmpty())
			return new ErrorResult(Messages.emailNotVerified);

		emailActivation.get().setActivated(true);
		emailActivationDao.save(emailActivation.get());

		return new SuccessResult(Messages.emailVerified);
	}
}
