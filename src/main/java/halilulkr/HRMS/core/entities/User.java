package halilulkr.HRMS.core.entities;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.*;

@Data
@NoArgsConstructor
@ToString  //
@EqualsAndHashCode //
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotBlank
	@Email
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@NotBlank
	@Size(max = 100)
	@Column(name = "password")
	private String password;
	
	@NotNull
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@NotNull
	@Column(name = "is_active")
	private boolean isActive = true;
	
	@NotNull
	@Column(name = "is_deleted")
	private boolean isDeleted = false;
	
	@Builder
	public User(final int id, @NotBlank @Email @Size(max = 100) final String email,
			@NotBlank @Size(max = 100) final String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
