package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.MernisActivationService;
import halilulkr.HRMS.business.adapters.mernisService.PersonForValidateFromMernisService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.MernisActivationDao;
import halilulkr.HRMS.entities.concretes.MernisActivation;

@Service
public class MernisActivationManager implements MernisActivationService {
	private final MernisActivationDao mernisActivationDao;

	@Autowired
	public MernisActivationManager(final MernisActivationDao mernisActivationDao) {
		this.mernisActivationDao = mernisActivationDao;
	}

	@Override
	public Result add(final MernisActivation mernisActivation) {
		mernisActivationDao.save(mernisActivation);

		return new SuccessResult(Messages.mernisActivationAdded);
	}

	@Override
	public Result check(final PersonForValidateFromMernisService personForValidateFromMernisService) {
		// TODO Validate with Mernis System Adapter
		return new SuccessResult(Messages.mernisActivationVerified);
	}

	@Override
	public Result delete(final MernisActivation mernisActivation) {
		mernisActivationDao.delete(mernisActivation);

		return new SuccessResult(Messages.mernisActivationDeleted);
	}

	@Override
	public DataResult<List<MernisActivation>> getAll() {
		final List<MernisActivation> mernisActivations = mernisActivationDao.findAll();

		return new SuccessDataResult<List<MernisActivation>>(mernisActivations);
	}

	@Override
	public DataResult<MernisActivation> getById(final Integer id) {
		final Optional<MernisActivation> mernisActivation = mernisActivationDao.findById(id);

		if (mernisActivation.isEmpty())
			return new ErrorDataResult<MernisActivation>(Messages.mernisActivationNotFound);

		return new SuccessDataResult<MernisActivation>(mernisActivation.get());
	}

	@Override
	public Result update(final MernisActivation mernisActivation) {
		mernisActivationDao.save(mernisActivation);

		return new SuccessResult(Messages.mernisActivationUpdated);
	}

}
