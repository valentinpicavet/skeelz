package skeelz.modele;

import java.util.ArrayList;
import java.util.List;


public class Personne {

		private Long id;
		private int version;
		private String nom;
		private String prenom;
		private String telephone;
		private int noteGlobal;
		private Utilisateur utilisateur;
		private List<CoursPersonne> coursPersonne = new ArrayList<CoursPersonne>();
		private List<QCMPersonne> qcmPersonne = new ArrayList<QCMPersonne>();
		private List<BilanCompetence> bilanCompetence = new ArrayList<BilanCompetence>();
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
		public String getPrenom() {
			return prenom;
		}
		public void setPrenom(String prenom) {
			this.prenom = prenom;
		}
		public String getTelephone() {
			return telephone;
		}
		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}
		public int getNoteGlobal() {
			return noteGlobal;
		}
		public void setNoteGlobal(int noteGlobal) {
			this.noteGlobal = noteGlobal;
		}
		public Utilisateur getUtilisateur() {
			return utilisateur;
		}
		public void setUtilisateur(Utilisateur utilisateur) {
			this.utilisateur = utilisateur;
		}
		public List<CoursPersonne> getCoursPersonne() {
			return coursPersonne;
		}
		public void setCoursPersonne(List<CoursPersonne> coursPersonne) {
			this.coursPersonne = coursPersonne;
		}
		public List<QCMPersonne> getQcmPersonne() {
			return qcmPersonne;
		}
		public void setQcmPersonne(List<QCMPersonne> qcmPersonne) {
			this.qcmPersonne = qcmPersonne;
		}
		public List<BilanCompetence> getBilanCompetence() {
			return bilanCompetence;
		}
		public void setBilanCompetence(List<BilanCompetence> bilanCompetence) {
			this.bilanCompetence = bilanCompetence;
		}
		
		
		

}
