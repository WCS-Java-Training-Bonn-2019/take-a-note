package wildcodeschool.com.take_a_note.controller;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import wildcodeschool.com.take_a_note.entity.Notes;
import wildcodeschool.com.take_a_note.repository.NotesRepository;

@RestController
@RequestMapping("/api/v1/")
public class NotesRestController {

	private final NotesRepository repository;

	public NotesRestController(NotesRepository notesRepository) {
		this.repository = notesRepository;
	}

	@GetMapping("notes")
	public List<Notes> getAll() {
		return repository.findAll();
	}

	@GetMapping("notes/{id}")	
	public Notes get(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@PostMapping("notes")
	@ResponseStatus(HttpStatus.CREATED)
	public Notes newNote(@RequestBody Notes newNote) {
		newNote.setNotizen_id(null);
		return repository.save(newNote);
	}
	
	@PutMapping("notes/{id}")
	public Notes replace(@RequestBody Notes newNote, @PathVariable Long id) {
		return repository.findById(id).map(note -> {
			note.setNotizenname(newNote.getNotizenname());
			note.setNotizentext(newNote.getNotizentext());
			return repository.save(note);
		}).orElseThrow(() -> new ResourceNotFoundException(id));
	}

	@DeleteMapping("notes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
	}
}
