package skeelz.modele;

public class Paragraphe extends ElementDeCours {
	
	private String texte;
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
