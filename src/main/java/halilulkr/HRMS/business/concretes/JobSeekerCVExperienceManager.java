package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.JobSeekerCVExperienceService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.JobSeekerCVExperienceDao;
import halilulkr.HRMS.entities.concretes.JobSeekerCVExperience;

@Service
public class JobSeekerCVExperienceManager implements JobSeekerCVExperienceService {
	private JobSeekerCVExperienceDao jobSeekerCVExperienceDao;

	@Autowired
	public JobSeekerCVExperienceManager(final JobSeekerCVExperienceDao jobSeekerCVExperienceDao) {
		this.jobSeekerCVExperienceDao = jobSeekerCVExperienceDao;
	}

	@Override
	public Result add(final JobSeekerCVExperience jobSeekerCVExperience) {
		jobSeekerCVExperienceDao.save(jobSeekerCVExperience);

		return new SuccessResult(Messages.jobSeekerCVExperienceAdded);
	}

	@Override
	public Result delete(final JobSeekerCVExperience jobSeekerCVExperience) {
		jobSeekerCVExperienceDao.delete(jobSeekerCVExperience);

		return new SuccessResult(Messages.jobSeekerCVExperienceDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAll() {
		final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerCVExperiences);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVExperience> jobSeekerCVExperiences = jobSeekerCVExperienceDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerCVExperiences);
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAllByJobSeekerCV_IdOrderByQuitDate(final int jobSeekerCVId,
			final Direction direction) {
		final List<JobSeekerCVExperience> jobSeekerEducations = direction.isAscending()
				? jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDate(jobSeekerCVId)
				: jobSeekerCVExperienceDao.findAllByJobSeekerCV_IdOrderByQuitDateDesc(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVExperience>>(jobSeekerEducations);
	}

	@Override
	public DataResult<JobSeekerCVExperience> getById(final Integer id) {
		final Optional<JobSeekerCVExperience> jobSeekerCVExperience = jobSeekerCVExperienceDao.findById(id);

		if (jobSeekerCVExperience.isEmpty())
			return new ErrorDataResult<JobSeekerCVExperience>(Messages.jobSeekerCVExperienceNotFound);

		return new SuccessDataResult<JobSeekerCVExperience>(jobSeekerCVExperience.get());
	}

	@Override
	public Result update(final JobSeekerCVExperience jobSeekerCVExperience) {
		jobSeekerCVExperienceDao.save(jobSeekerCVExperience);

		return new SuccessResult(Messages.jobSeekerCVExperienceUpdated);
	}

}
