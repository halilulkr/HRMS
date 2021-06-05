package halilulkr.HRMS.entities.dtos;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import halilulkr.HRMS.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class EmailActivationForVerifyDto implements Dto{

	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	private String activationCode;
	
	@Builder
	public EmailActivationForVerifyDto(@NotBlank @Email final String email,
			@NotBlank final String activationCode) {
		this.email = email;
		this.activationCode = activationCode;
	}
}
