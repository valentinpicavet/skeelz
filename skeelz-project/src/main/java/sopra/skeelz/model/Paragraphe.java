package sopra.skeelz.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@DiscriminatorValue("Paragraphe")
public class Paragraphe extends ElementDeCours {
	@Column(length = 6000)
	@JsonView(Views.ViewCommon.class)
	private String texte;
	@JsonView(Views.ViewCommon.class)
	private String titre;

	public Paragraphe() {
		super();
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
