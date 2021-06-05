package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.EmailActivationService;
import halilulkr.HRMS.business.abstracts.JobSeekerService;
import halilulkr.HRMS.business.abstracts.MernisActivationService;
import halilulkr.HRMS.business.abstracts.UserService;
import halilulkr.HRMS.business.adapters.mernisService.PersonForValidateFromMernisService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.business.BusinessRules;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.ErrorResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.JobSeekerDao;
import halilulkr.HRMS.entities.concretes.JobSeeker;
import halilulkr.HRMS.entities.concretes.MernisActivation;
import halilulkr.HRMS.entities.dtos.JobSeekerForRegisterDto;

@Service
public class JobSeekerManager implements JobSeekerService {
	private final JobSeekerDao jobSeekerDao;
	private final UserService userService;
	private final MernisActivationService mernisActivationService;
	private final EmailActivationService emailActivationService;

	@Autowired
	public JobSeekerManager(final JobSeekerDao jobSeekerDao, final UserService userService,
			final MernisActivationService mernisActivationService,
			final EmailActivationService emailActivationService) {
		this.jobSeekerDao = jobSeekerDao;
		this.userService = userService;
		this.mernisActivationService = mernisActivationService;
		this.emailActivationService = emailActivationService;
	}

	@Override
	public Result add(final JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);

		return new SuccessResult(Messages.jobSeekerAdded);
	}

	private Result arePasswordMatch(final String password, final String confirmPassword) {
		return password.equals(confirmPassword) ? new SuccessResult() : new ErrorResult(Messages.passwordsNotMatch);
	}

	@Override
	public Result delete(final JobSeeker jobSeeker) {
		jobSeekerDao.delete(jobSeeker);

		return new SuccessResult(Messages.jobSeekerDeleted);
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		final List<JobSeeker> jobSeekers = jobSeekerDao.findAll();

		return new SuccessDataResult<List<JobSeeker>>(jobSeekers);
	}

	@Override
	public DataResult<JobSeeker> getById(final Integer id) {
		final Optional<JobSeeker> jobSeeker = jobSeekerDao.findById(id);

		if (jobSeeker.isEmpty())
			return new ErrorDataResult<JobSeeker>(Messages.jobSeekerNotFound);

		return new SuccessDataResult<JobSeeker>(jobSeeker.get());
	}

	@Override
	public DataResult<JobSeeker> getByIdentityNumber(final String identityNumber) {
		final Optional<JobSeeker> jobSeeker = jobSeekerDao.findByIdentityNumber(identityNumber);

		if (jobSeeker.isEmpty())
			return new ErrorDataResult<JobSeeker>(Messages.jobSeekerNotFound);

		return new SuccessDataResult<JobSeeker>(jobSeeker.get());
	}

	@Override
	public Result isNotNationalIdentityExist(final String identityNumber) {
		return jobSeekerDao.findByIdentityNumber(identityNumber).isEmpty() ? new SuccessResult()
				: new ErrorResult(Messages.jobSeekerWithIdentityNumberAlreadyExits);
	}

	@Override
	public Result register(final JobSeekerForRegisterDto jobSeekerForRegisterDto) {
		final Result businessRulesResult = BusinessRules.run(
				userService.isNotEmailExist(jobSeekerForRegisterDto.getEmail()),
				isNotNationalIdentityExist(jobSeekerForRegisterDto.getIdentityNumber()),
				arePasswordMatch(jobSeekerForRegisterDto.getPassword(), jobSeekerForRegisterDto.getConfirmPassword()),
				mernisActivationService.check(new PersonForValidateFromMernisService(
						Long.parseLong(jobSeekerForRegisterDto.getIdentityNumber()),
						jobSeekerForRegisterDto.getFirstName(),
						jobSeekerForRegisterDto.getLastName(),
						jobSeekerForRegisterDto.getBirthDate().getYear())));
		if (!businessRulesResult.isSuccess())
			return businessRulesResult;

		final JobSeeker jobSeeker = JobSeeker.childBuilder()
				.email(jobSeekerForRegisterDto.getEmail())
				.password(jobSeekerForRegisterDto.getPassword())
				.firstName(jobSeekerForRegisterDto.getFirstName())
				.lastName(jobSeekerForRegisterDto.getLastName())
				.identityNumber(jobSeekerForRegisterDto.getIdentityNumber())
				.birthDate(jobSeekerForRegisterDto.getBirthDate())
				.build();
		jobSeekerDao.save(jobSeeker);

		emailActivationService.createAndSendActivationCodeByMail(jobSeeker, jobSeeker.getEmail());
		mernisActivationService.add(MernisActivation.builder().user(jobSeeker).build());

		return new SuccessResult(Messages.jobSeekerAdded);
	}

	@Override
	public Result update(final JobSeeker jobSeeker) {
		jobSeekerDao.save(jobSeeker);

		return new SuccessResult(Messages.jobSeekerUpdated);
	}

}
