package wildcodeschool.com.take_a_note.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	@GetMapping("/note_anlegen")

	public String indexanlegen() {

		return "note_anlegen";
	}

	@GetMapping("/details/{notizenId}")

	public String indexdetails(@PathVariable Long notizenId, Model model) {

		model.addAttribute("note", notesRepository.findById(notizenId).get()); // Optional[wildcodeschool.com.take_a_note.entity.Notes@247bba1a]

		return "details";
	}

	@GetMapping("/editieren/{notizenId}")

	public String indexeditieren(@PathVariable Long notizenId, Model model) {

		model.addAttribute("note", notesRepository.findById(notizenId).get()); // Optional[wildcodeschool.com.take_a_note.entity.Notes@247bba1a]

		return "editieren";
	}
	
	
	@GetMapping("/loeschen/{notizenId}")

	public String loeschen(@PathVariable("notizenId") Long notizenId) {
		
		// 1. Notiz im Repo löschen (mit der Id notizenId)
		// 2. Die Listen-View zurückgeben
		
	 	 System.out.println("Es wurde loeschen aufgerufen");
		 notesRepository.deleteById(notizenId); 
		return "redirect:/notes";
		
//		repository.deleteById(id);
//		return "redirect:/authors";
	}

	

	
	
	@PostMapping("/note/upsert")
	public String postNotes(@ModelAttribute Notes note, @RequestParam(required = false) String edit,
			@RequestParam(required = false) String delete) {
		
//		if ("löschen".equals(delete)) {
//			System.out.println("Es wurde " + delete + " gedrückt!");
//		}
//		
		
		notesRepository.save(note);

//    	System.out.println(notizenId);

		return "redirect:/editieren/" + note.getNotizen_id();
	}

}
