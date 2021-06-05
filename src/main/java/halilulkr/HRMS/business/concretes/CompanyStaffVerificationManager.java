package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.CompanyStaffVerificationService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.ErrorResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.CompanyStaffVerificationDao;
import halilulkr.HRMS.entities.concretes.CompanyStaffVerification;

@Service
public class CompanyStaffVerificationManager implements CompanyStaffVerificationService{

	private CompanyStaffVerificationDao companyStaffVerificationDao;
	
	@Autowired
	public CompanyStaffVerificationManager(final CompanyStaffVerificationDao companyStaffVerificationDao) {
		super();
		this.companyStaffVerificationDao = companyStaffVerificationDao;
	}

	@Override
	public Result add(final CompanyStaffVerification companyStaffVerification) {
		this.companyStaffVerificationDao.save(companyStaffVerification);
		return new SuccessResult(Messages.companyStaffVerificationAdded);
	}

	@Override
	public Result delete(final CompanyStaffVerification companyStaffVerification) {
		this.companyStaffVerificationDao.delete(companyStaffVerification);
		return new SuccessResult(Messages.companyStaffVerificationDeleted);
	}

	@Override
	public DataResult<List<CompanyStaffVerification>> getAll() {
		final List<CompanyStaffVerification> companyStaffVerifications = this.companyStaffVerificationDao.findAll();
		
		return new SuccessDataResult<List<CompanyStaffVerification>>(companyStaffVerifications);
	}

	@Override
	public DataResult<CompanyStaffVerification> getById(final Integer id) {
		final Optional<CompanyStaffVerification> companyStaffVerification = this.companyStaffVerificationDao.findById(id);
		
		if(companyStaffVerification.isEmpty()) {
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);
		}
		
		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public Result update(final CompanyStaffVerification companyStaffVerification) {
		this.companyStaffVerificationDao.save(companyStaffVerification);
		
		return new SuccessResult(Messages.companyStaffVerificationUpdated);
	}

	@Override
	public DataResult<CompanyStaffVerification> getByUserId(final int userId) {
		final Optional<CompanyStaffVerification> companyStaffVerification = this.companyStaffVerificationDao.findByUser_Id(userId);
		
		if(companyStaffVerification.isEmpty()) {
			return new ErrorDataResult<CompanyStaffVerification>(Messages.companyStaffVerificationNotFound);
		}
		
		return new SuccessDataResult<CompanyStaffVerification>(companyStaffVerification.get());
	}

	@Override
	public Result verify(final int userId) {
		final DataResult<CompanyStaffVerification> companyStaffVerification = getByUserId(userId);
		
		if(!companyStaffVerification.isSuccess()) {
			return new ErrorResult(Messages.companyStaffVerificationNotFound);
		}
		
		companyStaffVerification.getData().setApproved(true);
		companyStaffVerificationDao.save(companyStaffVerification.getData());
		
		return new SuccessResult(Messages.companyStaffVerificationVerified);
	}

}
