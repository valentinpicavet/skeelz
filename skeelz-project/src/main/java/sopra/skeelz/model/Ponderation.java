package sopra.skeelz.model;

public enum Ponderation {
	CINQ(5), DIX(10), QUINZE(15), VINGT(20);

	private Ponderation(int label) {
		this.label = label;
	}

	private final int label;

	public int getLabel() {
		return label;
	}

}
