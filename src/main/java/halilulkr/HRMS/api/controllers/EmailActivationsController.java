package halilulkr.HRMS.api.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import halilulkr.HRMS.business.abstracts.EmailActivationService;
import halilulkr.HRMS.core.utilities.results.Result;
import halilulkr.HRMS.entities.dtos.EmailActivationForVerifyDto;

@RestController
@RequestMapping("/api/emailactivations")
public class EmailActivationsController {

	private final EmailActivationService emailActivationService;

	@Autowired
	public EmailActivationsController(EmailActivationService emailActivationService) {
		super();
		this.emailActivationService = emailActivationService;
	}
	
	public ResponseEntity<Result> verify(@Valid final EmailActivationForVerifyDto activationForVerifyDto){
		final Result result = emailActivationService.verify(activationForVerifyDto);
		
		if(!result.isSuccess()) {
			return new ResponseEntity<Result>(result, HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok(result);
	}
}
