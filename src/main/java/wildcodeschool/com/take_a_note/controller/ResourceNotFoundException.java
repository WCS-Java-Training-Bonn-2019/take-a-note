package wildcodeschool.com.take_a_note.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5909234906542641361L;

	
	ResourceNotFoundException(Long id) {
		super("Could not find resource " + id);
	}

}