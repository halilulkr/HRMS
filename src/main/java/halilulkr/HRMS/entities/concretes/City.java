package halilulkr.HRMS.entities.concretes;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.*;

@Data
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "cities")
public class City {

	@Id
	@Column(name = "id")
	private short id;
	
	@NotBlank
	@Size(max = 50)
	@Column(name = "name")
	private String name;
	
	@Builder
	public City(final short id, @NotBlank @Size(max = 50) final String name) {
		this.id = id;
		this.name = name;
	}
}
