package skeelz.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "cours_id", "competence_id"})})
public class CoursCompetence {
	
	@Id
	@GeneratedValue
	private Long id; 
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private RelationCours relationCours;
	@ManyToOne
	@JoinColumn(name = "cours_id")//, nullable = false)
	private Cours cours;
	@ManyToOne
	@JoinColumn(name = "competence_id")//, nullable = false)
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
