package skeelz.modele;

public enum Ponderation {
  CINQ(5);
	
	private Ponderation(int label) {
		this.label = label;
	}

	private final int label;

	public int getLabel() {
		return label;
	}

}
