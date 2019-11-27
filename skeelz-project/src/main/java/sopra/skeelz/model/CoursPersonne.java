package sopra.skeelz.model;

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
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "personne_id", "cours_id"})})
public class CoursPersonne {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private EtatCours etatCours;
	@ManyToOne
	@JoinColumn(name = "personne_id")//, nullable = false)
	private Personne personne;
	@ManyToOne
	@JoinColumn(name = "cours_id")//, nullable = false)
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
