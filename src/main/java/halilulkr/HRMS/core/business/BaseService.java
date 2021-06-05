package halilulkr.HRMS.core.business;

import java.util.List;

import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;

public interface BaseService<T, Id> {

	Result add(T entity);
	
	Result delete(T entity);
	
	DataResult<List<T>> getAll();
	
	DataResult<T> getById(Id id);
	
	Result update(T entity);
}
