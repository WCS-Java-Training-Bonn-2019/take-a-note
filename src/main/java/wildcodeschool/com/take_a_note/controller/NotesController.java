package wildcodeschool.com.take_a_note.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import wildcodeschool.com.take_a_note.entity.Notes;
import wildcodeschool.com.take_a_note.repository.NotesRepository;



@Controller
public class NotesController {

	
	@Autowired
	private NotesRepository notesRepository;
	
	@GetMapping("/notes")

	public String index(Model model) {
		model.addAttribute("notes", notesRepository.findAll());

		return "seite_anzeigen_liste";
	}

	@GetMapping("/anlegen")

	public String indexanlegen() {

		return "note_anlegen";
	}

	@GetMapping("/details/{notizenId}")

	public String indexdetails(@PathVariable Long notizenId, Model model) {
		
		
		model.addAttribute("note", notesRepository.findById(notizenId).get());      //Optional[wildcodeschool.com.take_a_note.entity.Notes@247bba1a]

	
		
		return "details";
	}

	@GetMapping("/editieren")

	public String indexeditieren() {

		return "editieren";
	}
}
