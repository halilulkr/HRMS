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

import halilulkr.HRMS.business.abstracts.JobSeekerCVLanguageService;
import halilulkr.HRMS.core.utilities.results.DataResult;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.concretes.JobSeekerCVLanguage;

@RestController
@RequestMapping("/api/jobseekers/cvs/languages")
public class JobSeekerCVLanguagesController {
	private JobSeekerCVLanguageService jobSeekerCVLanguageService;

	@Autowired
	public JobSeekerCVLanguagesController(final JobSeekerCVLanguageService jobSeekerCVLanguageService) {
		this.jobSeekerCVLanguageService = jobSeekerCVLanguageService;
	}

	@PostMapping("/add")
	public ResponseEntity<Result> add(@RequestBody @Valid final JobSeekerCVLanguage jobSeekerCVLanguage) {
		final Result result = jobSeekerCVLanguageService.add(jobSeekerCVLanguage);

		return ResponseEntity.ok(result);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Result> delete(@RequestBody final JobSeekerCVLanguage jobSeekerCVLanguage) {
		final Result result = jobSeekerCVLanguageService.delete(jobSeekerCVLanguage);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAll() {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService.getAll();

		return ResponseEntity.ok(result);
	}

	@GetMapping("/getall/byjobseekercvid")
	public ResponseEntity<DataResult<List<JobSeekerCVLanguage>>> getAllByJobSeekerCV_Id(final int jobSeekerCVId) {
		final DataResult<List<JobSeekerCVLanguage>> result = jobSeekerCVLanguageService
				.getAllByJobSeekerCV_Id(jobSeekerCVId);

		return ResponseEntity.ok(result);
	}

	@GetMapping("/get/byid")
	public ResponseEntity<DataResult<JobSeekerCVLanguage>> getbyid(final int id) {
		final DataResult<JobSeekerCVLanguage> result = jobSeekerCVLanguageService.getById(id);

		return ResponseEntity.ok(result);
	}

	@PostMapping("/update")
	public ResponseEntity<Result> update(@RequestBody @Valid final JobSeekerCVLanguage jobSeekerCVLanguage) {
		final Result result = jobSeekerCVLanguageService.update(jobSeekerCVLanguage);

		return ResponseEntity.ok(result);
	}
}
