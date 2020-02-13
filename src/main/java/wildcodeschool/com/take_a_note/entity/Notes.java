package wildcodeschool.com.take_a_note.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Notes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long notizen_id;
    private Long user_id;
    private String notizenname;
    private String notizentext;

    // Konstruktor für ein Notizen-Objekt 
    public Notes(Long notizen_id, Long user_id, String notizenname, String notizentext) {
        this.notizen_id = notizen_id;
        this.user_id = user_id;
        this.notizenname = notizenname;
        this.notizentext = notizentext;
    }
    
    public Long getNotizen_id() {
		return notizen_id;
	}
	public void setNotizen_id(Long notizen_id) {
		this.notizen_id = notizen_id;
	}



	public void setNotizenname(String notizenname) {
		this.notizenname = notizenname;
	}
    
    public String getNotizenname() {
        return notizenname;
    }

	
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public String getNotizentext() {
		return notizentext;
	}

	public void setNotizentext(String notizentext) {
		this.notizentext = notizentext;
	}

  


}