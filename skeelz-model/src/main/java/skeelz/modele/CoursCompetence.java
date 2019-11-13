package skeelz.modele;

public class CoursCompetence {
	private Long id; 
	private int version;
	private RelationCours relationCours;
	private Cours cours;
	private Competence competence;
	
	
	
	public CoursCompetence() {
		super();
	}
	
	
	
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
	public RelationCours getRelationCours() {
		return relationCours;
	}
	public void setRelationCours(RelationCours relationCours) {
		this.relationCours = relationCours;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	public Competence getCompetence() {
		return competence;
	}
	public void setCompetence(Competence competence) {
		this.competence = competence;
	}
	
	
	
	

}
