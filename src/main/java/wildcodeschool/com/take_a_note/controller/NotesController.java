package wildcodeschool.com.take_a_note.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class NotesController {
	
	@GetMapping("/notes")
	
	public String index() {
				
		return "seite_anzeigen_liste";
	}
	

}
