package halilulkr.HRMS.business.abstracts;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.WebSite;

public interface WebSiteService extends BaseService<WebSite, Short> {
	DataResult<WebSite> getByName(String name);
}
