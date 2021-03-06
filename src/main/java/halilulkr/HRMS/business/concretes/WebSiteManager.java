package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.WebSiteService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.WebSiteDao;
import halilulkr.HRMS.entities.concretes.WebSite;

@Service
public class WebSiteManager implements WebSiteService {
	private WebSiteDao webSiteDao;

	@Autowired
	public WebSiteManager(final WebSiteDao webSiteDao) {
		this.webSiteDao = webSiteDao;
	}

	@Override
	public Result add(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.webSiteAdded);
	}

	@Override
	public Result delete(final WebSite webSite) {
		webSiteDao.delete(webSite);

		return new SuccessResult(Messages.webSiteDeleted);
	}

	@Override
	public DataResult<List<WebSite>> getAll() {
		final List<WebSite> webSites = webSiteDao.findAll();

		return new SuccessDataResult<List<WebSite>>(webSites);
	}

	@Override
	public DataResult<WebSite> getById(final Short id) {
		final Optional<WebSite> webSite = webSiteDao.findById(id);

		if (webSite.isEmpty())
			return new ErrorDataResult<WebSite>(Messages.webSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public DataResult<WebSite> getByName(final String name) {
		final Optional<WebSite> webSite = webSiteDao.findByName(name);

		if (webSite.isEmpty())
			return new ErrorDataResult<WebSite>(Messages.webSiteNotFound);

		return new SuccessDataResult<WebSite>(webSite.get());
	}

	@Override
	public Result update(final WebSite webSite) {
		webSiteDao.save(webSite);

		return new SuccessResult(Messages.webSiteUpdated);
	}
}
