package kodlama.io.Devs.entities.concretes;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name="SubTechnologies")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SubTechnologies {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "language_id")
    private ProgrammingLanguage programmingLanguage;

}
