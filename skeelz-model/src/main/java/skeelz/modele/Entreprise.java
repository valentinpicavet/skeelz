package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

public class Entreprise {

	private Long id;
	private int version;
	private String nom;
	private String numeroSiret;
	private String typeContrat;
	private List<Utilisateur> administrateur = new ArrayList<Utilisateur>();
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
	public List<Utilisateur> getAdministrateur() {
		return administrateur;
	}
	public void setAdministrateur(List<Utilisateur> administrateur) {
		this.administrateur = administrateur;
	}
	
	
}
