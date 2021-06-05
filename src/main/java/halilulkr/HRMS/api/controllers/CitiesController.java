package halilulkr.HRMS.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import halilulkr.HRMS.business.abstracts.CityService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CitiesController {

	private CityService cityService;

	@Autowired
	public CitiesController(final CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<City>>> getAll() {
		final DataResult<List<City>> result = this.cityService.getAll();
	
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbyid")
	public ResponseEntity<DataResult<City>> getById(final short id) {
		final DataResult<City> result = this.cityService.getById(id);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbyname")
	public ResponseEntity<DataResult<City>> getByName(final String name) {
		final DataResult<City> result = this.cityService.getByName(name);
		
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getbynamecontains")
	public ResponseEntity<DataResult<List<City>>> getByNameContains(final String name) {
		final DataResult<List<City>> result = this.cityService.getByNameContains(name);
		
		return ResponseEntity.ok(result);
	}
}
