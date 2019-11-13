package skeelz.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class BilanCompetence {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "skeelz_id")
	private Skeelz skeelz;
	@ManyToOne
	@JoinColumn(name = "competence_id")
	private Competence competence;
	@ManyToOne
	@JoinColumn(name = "personne_id")
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
