package skeelz.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "skeelz_id", "competence_id", "personne_id"})})
public class BilanCompetence {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@ManyToOne
	@JoinColumn(name = "competenceSkeelz_id")//, nullable = false)
	private CompetenceSkeelz competenceSkeelz;
	@ManyToOne
	@JoinColumn(name = "personne_id")//, nullable = false)
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
	public CompetenceSkeelz getCompetenceSkeelz() {
		return competenceSkeelz;
	}
	public void setCompetenceSkeelz(CompetenceSkeelz competenceSkeelz) {
		this.competenceSkeelz = competenceSkeelz;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
