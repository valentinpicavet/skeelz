package skeelz.modele;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "personne_id", "module_id"})})
public class QCMPersonne {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private int nbTentative;
	private boolean statutQCM;
	@Temporal(TemporalType.DATE)
	private Date dateDerniereTentative;
	
	@ManyToOne
	@JoinColumn(name = "personne_id", nullable = false)
	private Personne personne;
	@ManyToOne
	@JoinColumn(name = "module_id", nullable = false)
	private Module module;
	
	
	
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
	public int getNbTentative() {
		return nbTentative;
	}
	public void setNbTentative(int nbTentative) {
		this.nbTentative = nbTentative;
	}
	public boolean isStatutQCM() {
		return statutQCM;
	}
	public void setStatutQCM(boolean statutQCM) {
		this.statutQCM = statutQCM;
	}
	public Date getDateDerniereTentative() {
		return dateDerniereTentative;
	}
	public void setDateDerniereTentative(Date dateDerniereTentative) {
		this.dateDerniereTentative = dateDerniereTentative;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	
	


}
