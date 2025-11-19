package eus.birt.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.ad.domain.Book;
import eus.birt.ad.repository.BookRepository;
import eus.birt.ad.repository.GenreRepository;

@Controller
@RequestMapping ("/books")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	GenreRepository genreRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		bookRepository.deleteById(id);
		return "redirect:/books";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Book book = new Book();
		model.addAttribute("book", book);
		model.addAttribute("genres", genreRepository.findAll());
		return "bookForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Book book) {
		bookRepository.save(book);
		return "redirect:/books";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("book", bookRepository.findById(id));
		model.addAttribute("genres", genreRepository.findAll());
		return "bookForm";
	}
	

}