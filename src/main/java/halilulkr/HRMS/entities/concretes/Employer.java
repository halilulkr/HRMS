package halilulkr.HRMS.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import halilulkr.HRMS.core.entities.User;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "user_id")
public class Employer extends User{

	@NotBlank
	@Size(max = 100)
	@Column(name = "company_name")
	private String companyName;

	@NotBlank
	@Size(max = 100)
	@Column(name = "website")
	private String website;

	@NotBlank
	@Size(max = 100)
	@Column(name = "corporate_email")
	private String corporateEmail;

	@NotBlank
	@Size(max = 15)
	@Column(name = "phone")
	private String phone;

	@Builder(builderMethodName = "childBuilder")
	public Employer(final int id, @NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password, @NotBlank @Size(max = 100) final String companyName,
			@NotBlank @Size(max = 100) final String website, @NotBlank @Size(max = 100) final String corporateEmail,
			@NotBlank @Size(max = 15) final String phone) {
		super(id, email, password);
		this.companyName = companyName;
		this.website = website;
		this.corporateEmail = corporateEmail;
		this.phone = phone;
	}
}
