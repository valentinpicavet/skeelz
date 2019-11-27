package sopra.skeelz.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "skeelz_id", "competence_id", "personne_id"})})
public class BilanCompetence {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@ManyToOne
	@JoinColumn(name = "skeelz_id")//, nullable = false)
	private Skeelz skeelz;
	@ManyToOne
	@JoinColumn(name = "competence_id")//, nullable = false)
	private Competence competence;
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
