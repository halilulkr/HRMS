package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.JobSeekerCVSkillService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.JobSeekerCVSkillDao;
import halilulkr.HRMS.entities.concretes.JobSeekerCVSkill;


@Service
public class JobSeekerCVSkillManager implements JobSeekerCVSkillService {
	private JobSeekerCVSkillDao jobSeekerCVSkillDao;

	@Autowired
	public JobSeekerCVSkillManager(final JobSeekerCVSkillDao jobSeekerCVSkillDao) {
		this.jobSeekerCVSkillDao = jobSeekerCVSkillDao;
	}

	@Override
	public Result add(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillAdded);
	}

	@Override
	public Result delete(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.delete(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillDeleted);
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAll() {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAll();

		return new SuccessDataResult<List<JobSeekerCVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<List<JobSeekerCVSkill>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final List<JobSeekerCVSkill> jobSeekerCVSkills = jobSeekerCVSkillDao.findAllByJobSeekerCV_Id(jobSeekerCVId);

		return new SuccessDataResult<List<JobSeekerCVSkill>>(jobSeekerCVSkills);
	}

	@Override
	public DataResult<JobSeekerCVSkill> getById(final Integer id) {
		final Optional<JobSeekerCVSkill> jobSeekerCVSkill = jobSeekerCVSkillDao.findById(id);

		if (jobSeekerCVSkill.isEmpty())
			return new ErrorDataResult<JobSeekerCVSkill>(Messages.jobSeekerCVSkillNotFound);

		return new SuccessDataResult<JobSeekerCVSkill>(jobSeekerCVSkill.get());
	}

	@Override
	public Result update(final JobSeekerCVSkill jobSeekerCVSkill) {
		jobSeekerCVSkillDao.save(jobSeekerCVSkill);

		return new SuccessResult(Messages.jobSeekerCVSkillUpdated);
	}

}
