package eus.birt.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.ad.repository.BookRepository;
import eus.birt.ad.repository.GenreRepository;




@Controller
	public class MainController {
	
	
	@Autowired
   	private BookRepository bookRepository;
	
	
	@Autowired
   	private GenreRepository genreRepository;
	
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/books"})
	public String getCyclists(Model model) {
		model.addAttribute("books", bookRepository.findAll());
		return "books";
	}
	
	@GetMapping ({"/genres"})
	public String getTeams(Model model) {
		model.addAttribute("genres", genreRepository.findAll());
		return "genres";
	}
	
	@GetMapping ({"/about"})
	public String getAbout() {
		
		return "about";
	}
}
	
