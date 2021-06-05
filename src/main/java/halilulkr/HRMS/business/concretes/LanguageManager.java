package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.LanguageService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.LanguageDao;
import halilulkr.HRMS.entities.concretes.Language;

@Service
public class LanguageManager implements LanguageService {
	private LanguageDao languageDao;

	@Autowired
	public LanguageManager(final LanguageDao languageDao) {
		this.languageDao = languageDao;
	}

	@Override
	public Result add(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.languageAdded);
	}

	@Override
	public Result delete(final Language language) {
		languageDao.delete(language);

		return new SuccessResult(Messages.languageDeleted);
	}

	@Override
	public DataResult<List<Language>> getAll() {
		final List<Language> language = languageDao.findAll();

		return new SuccessDataResult<List<Language>>(language);
	}

	@Override
	public DataResult<Language> getById(final String id) {
		final Optional<Language> language = languageDao.findById(id);

		if (language.isEmpty())
			return new ErrorDataResult<Language>(Messages.languageNotFound);

		return new SuccessDataResult<Language>(language.get());
	}

	@Override
	public Result update(final Language language) {
		languageDao.save(language);

		return new SuccessResult(Messages.languageUpdated);
	}

}
