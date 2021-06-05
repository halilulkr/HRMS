package halilulkr.HRMS.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import halilulkr.HRMS.business.abstracts.CityService;
import halilulkr.HRMS.business.constants.Messages;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.ErrorDataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.core.utilities.results.SuccessDataResult;
import halilulkr.HRMS.core.utilities.results.SuccessResult;
import halilulkr.HRMS.dataAccess.abstracts.CityDao;
import halilulkr.HRMS.entities.concretes.City;

@Service
public class CityManager implements CityService{

	private CityDao cityDao;
	
	@Autowired
	public CityManager(final CityDao cityDao) {
		super();
		this.cityDao = cityDao;
	}

	@Override
	public Result add(final City entity) {
		this.cityDao.save(entity);
		return new SuccessResult(Messages.cityAdded);
	}

	@Override
	public Result delete(final City entity) {
		this.cityDao.delete(entity);
		return new SuccessResult(Messages.cityDeleted);
	}

	@Override
	public DataResult<List<City>> getAll() {
		
		final List<City> cities = this.cityDao.findAll();
		
		return new SuccessDataResult<List<City>>(cities);
	}

	@Override
	public DataResult<City> getById(final Short id) {
		
		final Optional<City> city = cityDao.findById(id);
		
		if(city.isEmpty()) {
			return new ErrorDataResult<City>(Messages.cityNotFound);
		}
		
		return new SuccessDataResult<City>(city.get());
	}

	@Override
	public Result update(City city) {
		this.cityDao.save(city);
		return new SuccessResult(Messages.cityUpdated);
	}

	@Override
	public DataResult<City> getByName(String name) {
		
		final Optional<City> city = this.cityDao.findByName(name);
		
		return new SuccessDataResult<City>();
	}

	@Override
	public DataResult<List<City>> getByNameContains(String name) {
		final Optional<List<City>> city = this.cityDao.findByNameContains(name);
		return new SuccessDataResult<List<City>>(city.get());
	}

}
