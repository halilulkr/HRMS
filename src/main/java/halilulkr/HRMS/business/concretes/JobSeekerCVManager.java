package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.JobSeekerCVService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.JobSeekerCVDao;
import halilulkr.HRMS.entities.concretes.JobSeekerCV;

@Service
public class JobSeekerCVManager implements JobSeekerCVService {
	private JobSeekerCVDao jobSeekerCVDao;

	@Autowired
	public JobSeekerCVManager(final JobSeekerCVDao jobSeekerCVDao) {
		this.jobSeekerCVDao = jobSeekerCVDao;
	}

	@Override
	public Result add(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVAdded);
	}

	@Override
	public Result delete(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.delete(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCV>> getAll() {
		final List<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findAll();

		return new SuccessDataResult<List<JobSeekerCV>>(jobSeekerCV);
	}

	@Override
	public DataResult<JobSeekerCV> getById(final Integer id) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findById(id);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

		return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
	}

	@Override
	public DataResult<JobSeekerCV> getByJobSeeker_Id(final int jobSeekerId) {
		final Optional<JobSeekerCV> jobSeekerCV = jobSeekerCVDao.findByJobSeeker_Id(jobSeekerId);

		if (jobSeekerCV.isEmpty())
			return new ErrorDataResult<JobSeekerCV>(Messages.jobSeekerCVNotFound);

		return new SuccessDataResult<JobSeekerCV>(jobSeekerCV.get());
	}

	@Override
	public Result update(final JobSeekerCV jobSeekerCV) {
		jobSeekerCVDao.save(jobSeekerCV);

		return new SuccessResult(Messages.jobSeekerCVUpdated);
	}

}
