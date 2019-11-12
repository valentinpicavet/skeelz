package model;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {

	private Long id;
	private int version;
	private String nom;
	private String numeroSiret;
	private String typeContrat;
	private List<Personne> administrateurs = new ArrayList<Personne>();
	private SuperUser superUser;
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNumeroSiret() {
		return numeroSiret;
	}
	public void setNumeroSiret(String numeroSiret) {
		this.numeroSiret = numeroSiret;
	}
	public String getTypeContrat() {
		return typeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		this.typeContrat = typeContrat;
	}
	public List<Personne> getAdministrateurs() {
		return administrateurs;
	}
	public void setAdministrateurs(List<Personne> administrateurs) {
		this.administrateurs = administrateurs;
	}
	public SuperUser getSuperUser() {
		return superUser;
	}
	public void setSuperUser(SuperUser superUser) {
		this.superUser = superUser;
	}
	
	
	
	
}
