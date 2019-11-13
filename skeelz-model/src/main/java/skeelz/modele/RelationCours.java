package skeelz.modele;

public enum RelationCours {
	REQUIERE("Compétence requise"), VALIDE("Compétence validée");

	private RelationCours(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}

}
