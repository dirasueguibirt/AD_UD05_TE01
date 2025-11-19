package eus.birt.ad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.ad.domain.Genre;
import eus.birt.ad.repository.GenreRepository;

@Controller
@RequestMapping ("/genres")
public class GenreController {
	@Autowired
	GenreRepository genreRepository;
		
		@GetMapping("/delete/{id}")
		public String delete(@PathVariable("id") Long id) {
			genreRepository.deleteById(id);
		return "redirect:/genres";
		}
		
		@GetMapping("/new")
		public String initCreationForm(Model model) {
			Genre genre = new Genre();
			model.addAttribute("genre", genre);
			return "genreForm";
		}
		
		@PostMapping("/new/submit")
		public String processCreationForm(@ModelAttribute Genre genre) {
			genreRepository.save(genre);
			return "redirect:/genres";
		}
		
		@GetMapping("/edit/{id}")
		public String initEditForm(@PathVariable("id") Long id, Model model) {	
			model.addAttribute("genre", genreRepository.findById(id));
			return "genreForm";
		}

}