package skeelz.modele;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

@Entity
public class QCMPersonne {
	
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	private int nbTentative;
	private boolean statutQCM;
	private Date dateDerniereTentative;
	
	@ManyToOne
	@JoinColumn(name = "personne_id")
	private Personne personne;
	@ManyToOne
	@JoinColumn(name = "module_id")
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
