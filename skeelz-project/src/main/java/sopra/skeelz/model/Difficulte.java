package sopra.skeelz.model;

import com.fasterxml.jackson.annotation.JsonView;

public enum Difficulte {
	
	@JsonView(Views.ViewCommon.class)
	FACILE("Facile"),
	@JsonView(Views.ViewCommon.class)
	MOYEN("Moyen"),
	@JsonView(Views.ViewCommon.class)
	DIFFICILE("Difficile");

	private Difficulte(String label) {
		this.label = label;
	}

	private final String label;

	public String getLabel() {
		return label;
	}
}
