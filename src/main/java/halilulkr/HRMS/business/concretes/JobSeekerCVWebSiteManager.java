package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.JobSeekerCVWebSiteService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.JobSeekerCVWebSiteDao;
import halilulkr.HRMS.entities.concretes.JobSeekerCVWebSite;


@Service
public class JobSeekerCVWebSiteManager implements JobSeekerCVWebSiteService {
	private JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao;

	@Autowired
	public JobSeekerCVWebSiteManager(final JobSeekerCVWebSiteDao jobSeekerCVWebSiteDao) {
		this.jobSeekerCVWebSiteDao = jobSeekerCVWebSiteDao;
	}

	@Override
	public Result add(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteAdded);
	}

	@Override
	public Result delete(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.delete(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAll() {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<List<JobSeekerCVWebSite>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVWebSite> jobSeekerCVWebSites = jobSeekerCVWebSiteDao
				.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVWebSite>>(jobSeekerCVWebSites);
	}

	@Override
	public DataResult<JobSeekerCVWebSite> getById(final Integer id) {
		final Optional<JobSeekerCVWebSite> jobSeekerCVWebSite = jobSeekerCVWebSiteDao.findById(id);

		if (jobSeekerCVWebSite.isEmpty())
			return new ErrorDataResult<JobSeekerCVWebSite>(Messages.jobSeekerCVWebSiteNotFound);

		return new SuccessDataResult<JobSeekerCVWebSite>(jobSeekerCVWebSite.get());
	}

	@Override
	public Result update(final JobSeekerCVWebSite jobSeekerCVWebSite) {
		jobSeekerCVWebSiteDao.save(jobSeekerCVWebSite);

		return new SuccessResult(Messages.jobSeekerCVWebSiteUpdated);
	}
}
