package sopra.skeelz.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ExtraitCode")
public class ExtraitCode extends ElementDeCours {
	private String contenu;
	private String commentaire;
	
	
	
	public ExtraitCode() {
		super();
	}
	
	
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getCommentaire() {
		return commentaire;
	}
	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	
	
}
