package halilulkr.HRMS.entities.concretes;

import java.time.LocalDateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;

import halilulkr.HRMS.core.entities.User;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "company_staff_verifications")
public class CompanyStaffVerification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "is_approved")
	private boolean isApproved = false;
	
	@NotNull
	@Column(name = "created_at")
	private final LocalDateTime createdAt = LocalDateTime.now();
	
	@NotNull
	@PastOrPresent
	@Column(name = "approval_date")
	private LocalDateTime approvalDate;
	
	@NotNull
	@OneToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@Builder
	public CompanyStaffVerification(@NotNull final User user, @NotNull final boolean isApproved,
			@NotNull @PastOrPresent final LocalDateTime approvalDate) {
		this.user = user;
		this.isApproved = isApproved;
		this.approvalDate = approvalDate;
	}
}
