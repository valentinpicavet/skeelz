package skeelz.modele;

public enum EtatCours {

	VALIDE("valide"), SUIVI("suivi"), ADMINISTRE("administre");
	
	private EtatCours(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}
}
