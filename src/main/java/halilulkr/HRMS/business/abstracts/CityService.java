package halilulkr.HRMS.business.abstracts;

import java.util.List;

import halilulkr.HRMS.core.business.BaseService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.City;

public interface CityService extends BaseService<City, Short>{

	DataResult<City> getByName(String name);
	
	DataResult<List<City>> getByNameContains(String name);
}
