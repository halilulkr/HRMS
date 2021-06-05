package halilulkr.HRMS.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import halilulkr.HRMS.business.abstracts.CompanyStaffVerificationService;
import halilulkr.HRMS.core.utilities.results.Result;

@RestController
@RequestMapping("/api/companystaffverifications")
public class CompanyStaffVerificationsController {

	private CompanyStaffVerificationService companystaffverificationService;

	@Autowired
	public CompanyStaffVerificationsController(CompanyStaffVerificationService companystaffverificationService) {
		super();
		this.companystaffverificationService = companystaffverificationService;
	}
	
	@GetMapping("/verify")
	public ResponseEntity<Result> verify(@RequestParam final int userId) {
		final Result result = companystaffverificationService.verify(userId);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.ok(result);
	}
}
