package skeelz.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false, unique = true)
	private String mail;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false, unique = true)
	private String identifiant;
	@Column(nullable = false)
	private boolean administrateur;
	@Column(nullable = false)
	private boolean rh;
	@Column(nullable = false)
	private boolean superUser;
	
	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;
	@OneToOne
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
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public boolean isRh() {
		return rh;
	}
	public void setRh(boolean rh) {
		this.rh = rh;
	}
	public boolean isSuperUser() {
		return superUser;
	}
	public void setSuperUser(boolean superUser) {
		this.superUser = superUser;
	}
	public Entreprise getEntreprise() {
		return entreprise;
	}
	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	
	
}
