package halilulkr.HRMS.api.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import halilulkr.HRMS.business.abstracts.WebSiteService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.WebSite;

@RestController
@RequestMapping("/api/websites")
public class WebSitesController {
	private WebSiteService webSiteService;

	@Autowired
	public WebSitesController(final WebSiteService webSiteService) {
		this.webSiteService = webSiteService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final WebSite webSite) {
		final Result result = webSiteService.add(webSite);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final WebSite webSite) {
		final Result result = webSiteService.delete(webSite);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<WebSite>>> getAll() {
		final DataResult<List<WebSite>> result = webSiteService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byname")
	public ResponseEntity<DataResult<WebSite>> getByName(final String name) {
		final DataResult<WebSite> result = webSiteService.getByName(name);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final WebSite webSite) {
		final Result result = webSiteService.update(webSite);

		return ResponseEntity.ok(result);
	}
}
