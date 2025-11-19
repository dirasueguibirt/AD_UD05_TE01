package eus.birt.ad.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.ad.domain.Book;
import eus.birt.ad.domain.Genre;
import eus.birt.ad.repository.BookRepository;
import eus.birt.ad.repository.GenreRepository;

@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private GenreRepository genreRepository;
	
	
	@Override
	
	public void run(String... arg0) throws Exception {
        //creamos el genero primero
        Genre thriller = new Genre("Thriller");
        Genre fantasy = new Genre("Fantasy");
        genreRepository.save(thriller);
        genreRepository.save(fantasy);
        System.out.println("Number of genres: " + genreRepository.count());
        
        Book book1 = new Book("El Mentiroso", "Mikel Santiago",LocalDate.parse("2020-04-04"),"ES");
		bookRepository.save(book1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        

			
	}
	
}