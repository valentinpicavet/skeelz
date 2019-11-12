package model.Enum;

public enum Ponderation {
  CINQ(5);
	
	private Ponderation(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}

}
