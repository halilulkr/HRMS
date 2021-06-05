package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.CompanyStaffVerificationService;
import halilulkr.HRMS.business.abstracts.EmailActivationService;
import halilulkr.HRMS.business.abstracts.EmployerService;
import halilulkr.HRMS.business.abstracts.UserService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.business.BusinessRules;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.ErrorResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.EmployerDao;
import halilulkr.HRMS.entities.concretes.CompanyStaffVerification;
import halilulkr.HRMS.entities.concretes.Employer;
import halilulkr.HRMS.entities.dtos.EmployerForRegisterDto;



@Service
public class EmployerManager implements EmployerService {
	private final EmployerDao employerDao;
	private final UserService userService;
	private final EmailActivationService emailActivationService;
	private final CompanyStaffVerificationService companyStaffVerificationService;

	@Autowired
	public EmployerManager(final EmployerDao employerDao, final UserService userService,
			final EmailActivationService emailActivationService,
			final CompanyStaffVerificationService companyStaffVerificationService) {
		this.employerDao = employerDao;
		this.userService = userService;
		this.emailActivationService = emailActivationService;
		this.companyStaffVerificationService = companyStaffVerificationService;
	}

	@Override
	public Result add(final Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.employerAdded);
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public Result delete(final Employer employer) {
		employerDao.delete(employer);
		return new SuccessResult(Messages.employerDeleted);
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		final List<Employer> employers = employerDao.findAll();
		return new SuccessDataResult<List<Employer>>(employers);
	}

	@Override
	public DataResult<Employer> getById(final Integer id) {
		final Optional<Employer> employer = employerDao.findById(id);

		if (employer.isEmpty())
			return new ErrorDataResult<Employer>(Messages.employerNotFound);

		return new SuccessDataResult<Employer>(employer.get());
	}

	private Result isCorporateEmail(final String email, final String website) {
		return email.split("@")[1].equals(website) ? new SuccessResult() : new ErrorResult(Messages.emailNotCorporate);
	}

	@Override
	public Result isNotCorporateEmailExist(final String corporateEmail) {
		return employerDao.findByCorporateEmail(corporateEmail).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.employerWithCorporateEmailAlreadyExits);
	}

	@Override
	public Result register(final EmployerForRegisterDto employerForRegister) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(employerForRegister.getEmail()),
				isNotCorporateEmailExist(employerForRegister.getCorporateEmail()),
				arePasswordMatch(employerForRegister.getPassword(), employerForRegister.getConfirmPassword()),
				isCorporateEmail(employerForRegister.getCorporateEmail(), employerForRegister.getWebsite()));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final Employer employer = Employer.childBuilder()
				.email(employerForRegister.getEmail())
				.password(employerForRegister.getPassword())
				.companyName(employerForRegister.getCompanyName())
				.website(employerForRegister.getWebsite())
				.corporateEmail(employerForRegister.getCorporateEmail())
				.phone(employerForRegister.getPhone())
				.build();
		add(employer);

		emailActivationService
				.createAndSendActivationCodeByMail(employer, employer.getEmail(), employer.getCorporateEmail());
		companyStaffVerificationService.add(CompanyStaffVerification.builder().user(employer).build());

		return new SuccessResult(Messages.employerRegistered);
	}

	@Override
	public Result update(final Employer employer) {
		employerDao.save(employer);
		return new SuccessResult(Messages.employerUpdated);
	}

}
