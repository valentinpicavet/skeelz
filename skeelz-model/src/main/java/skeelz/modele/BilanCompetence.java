package skeelz.modele;

public class BilanCompetence {

	private Long id;
	private int version;
	private Skeelz skeelz;
	private Competence competence;
	private Personne personne;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Skeelz getSkeelz() {
		return skeelz;
	}
	public void setSkeelz(Skeelz skeelz) {
		this.skeelz = skeelz;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
