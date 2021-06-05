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


import halilulkr.HRMS.business.abstracts.JobSeekerCVWebSiteService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobSeekerCVWebSite;

@RestController
@RequestMapping("/api/jobseekers/cvs/websites")
public class JobSeekerCVWebSitesController {
	private JobSeekerCVWebSiteService jobSeekerCVWebSiteService;

	@Autowired
	public JobSeekerCVWebSitesController(final JobSeekerCVWebSiteService jobSeekerCVWebSiteService) {
		this.jobSeekerCVWebSiteService = jobSeekerCVWebSiteService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVWebSite jobSeekerCVWebSite) {
		final Result result = jobSeekerCVWebSiteService.add(jobSeekerCVWebSite);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVWebSite jobSeekerCVWebSite) {
		final Result result = jobSeekerCVWebSiteService.delete(jobSeekerCVWebSite);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAll() {
		final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVWebSite>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVWebSite>> result = jobSeekerCVWebSiteService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVWebSite jobSeekerCVWebSite) {
		final Result result = jobSeekerCVWebSiteService.update(jobSeekerCVWebSite);

		return ResponseEntity.ok(result);
	}
}
