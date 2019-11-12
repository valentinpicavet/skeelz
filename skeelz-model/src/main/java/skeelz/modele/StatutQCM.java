package skeelz.modele;

public enum StatutQCM {
   OUVERT("Ouvert"),FERME("Ferme"),VALIDE("Validé !");
	
	private StatutQCM(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}

}


