package halilulkr.HRMS.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import halilulkr.HRMS.core.entities.User;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "email_activations")
public class EmailActivation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Size(max = 200)
	@Column(name = "activation_code")
	private String activationCode;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@NotNull
	@Column(name = "is_activated")
	private boolean isActivated = false;
	
	@NotNull
	@Column(name = "created_at")
	private LocalDateTime createdAt = LocalDateTime.now();
	
	@NotNull
	@Column(name = "expiration_date")
	private LocalDateTime expirationDate;
	
	@Column(name = "activation_date")
	private LocalDateTime activationDate;
	
	@NotNull
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@Builder
	public EmailActivation(@NotNull User user, @NotBlank @Size(max = 200) final String activationCode,
			@NotBlank @Size(max = 100) final String email, @NotNull final boolean isActivated,
			@NotNull final LocalDateTime expirationDate, final LocalDateTime activationDate) {
		this.user = user;
		this.activationCode = activationCode;
		this.email = email;
		this.isActivated = isActivated;
		this.expirationDate = expirationDate;
		this.activationDate = activationDate;
	}
}
