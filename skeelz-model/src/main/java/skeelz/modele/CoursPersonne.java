package skeelz.modele;

public class CoursPersonne {

	private Long id;
	private int version;
	private EtatCours etatCours;
	
	private Personne personne;
	private Cours cours;
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
	public EtatCours getEtatCours() {
		return etatCours;
	}
	public void setEtatCours(EtatCours etatCours) {
		this.etatCours = etatCours;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
}
