package wildcodeschool.com.take_a_note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import wildcodeschool.com.take_a_note.repository.NotesRepository;



@Controller
public class NotesController {

	
	@Autowired
	private NotesRepository notesRepository;
	
	@GetMapping("/notes")

	public String index(Model model) {
		model.addAttribute("notes", notesRepository.findAll());
System.out.println(notesRepository.findAll());
return "seite_anzeigen_liste";
	}

	@GetMapping("/anlegen")

	public String indexanlegen() {

		return "note_anlegen";
	}

	@GetMapping("/details")

	public String indexdetails() {

		return "details";
	}

	@GetMapping("/editieren")

	public String indexeditieren() {

		return "editieren";
	}
}
