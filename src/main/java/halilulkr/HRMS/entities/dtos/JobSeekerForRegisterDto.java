package halilulkr.HRMS.entities.dtos;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import halilulkr.HRMS.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobSeekerForRegisterDto implements Dto{

	@NotBlank
	@Email
	@Size(max = 100)
	private String email;
	
	@NotBlank
	@Size(max = 100)
	private String password;
	
	@NotBlank
	@Size(max = 100)
	private String confirmPassword;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	@Size(max = 11, min = 11)
	private String identityNumber;
	
	@NotNull
	@Past
	private LocalDate birthDate;
	
	@Builder
	public JobSeekerForRegisterDto(@NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 100) final String confirmPassword,
			@NotBlank final String firstName, @NotBlank final String lastName,
			@NotBlank @Size(min = 11, max = 11) final String identityNumber, @NotNull @Past final LocalDate birthDate) {
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.firstName = firstName;
		this.lastName = lastName;
		this.identityNumber = identityNumber;
		this.birthDate = birthDate;
	}
}
