package wildcodeschool.com.take_a_note.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wildcodeschool.com.take_a_note.entity.Notes;



@Repository
public interface NotesRepository extends JpaRepository<Notes, Long> {

}
