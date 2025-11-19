package eus.birt.ad.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="genre")
public class Genre {
	@Id
	//@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="library")
	@SequenceGenerator(name = "col_gen2")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	private String name;
	
	
	@OneToMany (mappedBy = "genre",cascade = CascadeType.ALL)
	List <Book> books = new ArrayList<>();

	public Genre(String name) {
		super();
		this.name = name;
	}
	
	
}
