package sopra.skeelz.model;

public enum Etat {
	OUVERT("Ouvert"), FERME("Ferme"), ATTENTE("En attende de validation");

	private Etat(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}

}
