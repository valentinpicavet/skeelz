package skeelz.modele;

public enum Difficulte {
	Facile("Facile"), MOYEN("Moyen"), DIFFICILE("Difficile");
	
	private Difficulte(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}
}
