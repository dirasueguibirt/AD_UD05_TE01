package eus.birt.ad.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

//import eus.birt.ad.domain.Team;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="book")
public class Book {
	@Id
	//@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="library")
	@SequenceGenerator(name = "col_gen")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Author")
	private String author;
	
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate publicationDate;
	
	private String language;
	
	@ManyToOne
	@JoinColumn (name = "genre_id")
	private Genre genre;
	

	public Book(String name, String author, LocalDate publicationDate, String language) {
		super();
		this.name = name;
		this.author = author;
		this.publicationDate = publicationDate;
		this.language = language;
	}
}