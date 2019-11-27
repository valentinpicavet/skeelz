package sopra.skeelz.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("ImageCours")
public class ImageCours extends ElementDeCours{
	@JsonView(Views.ViewCommon.class)
	private String chemin;
	@JsonView(Views.ViewCommon.class)
	private String commentaire;
	
	
	public ImageCours() {
		super();
	}


	public String getChemin() {
		return chemin;
	}


	public void setChemin(String chemin) {
		this.chemin = chemin;
	}


	public String getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}




}
