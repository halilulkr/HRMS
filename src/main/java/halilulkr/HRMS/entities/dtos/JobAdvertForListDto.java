package halilulkr.HRMS.entities.dtos;

import java.time.LocalDateTime;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import halilulkr.HRMS.core.entities.Dto;
import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class JobAdvertForListDto implements Dto{

	@NotBlank
	@Size(max = 100)
	private String companyName;
	
	@NotBlank
	@Size(max = 50)
	private String title;
	
	@Positive
	private int numberOfOpenPositions;
	
	@Past
	private LocalDateTime createdAt;
	
	@Future
	private LocalDateTime applicationDeadline;
	
	@Builder
	public JobAdvertForListDto(@NotBlank @Size(max = 100) final String companyName,
			@NotBlank @Size(max = 50) final String title, @Positive final int numberOfOpenPositions,
			@Past final LocalDateTime createdAt, @Future final LocalDateTime applicationDeadline) {
		this.title = title;
		this.applicationDeadline = applicationDeadline;
		this.companyName = companyName;
		this.createdAt = createdAt;
		this.numberOfOpenPositions = numberOfOpenPositions;
	}
}
