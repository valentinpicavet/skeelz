package sopra.skeelz.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.QCMPersonne;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.model.Views;

public class PersonneDTO {
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private String telephone;
	@JsonView(Views.ViewCommon.class)
	private int noteGlobal;
	@JsonView(Views.ViewCommon.class)
	private Utilisateur utilisateur;
	@JsonView(Views.ViewCommon.class)
	private List<CoursPersonne> coursPersonne = new ArrayList<CoursPersonne>();
	@JsonView(Views.ViewCommon.class)
	private List<QCMPersonne> qcmPersonne = new ArrayList<QCMPersonne>();
	@JsonView(Views.ViewCommon.class)
	private List<BilanCompetence> bilanCompetence = new ArrayList<BilanCompetence>();
	@JsonView(Views.ViewCommon.class)
	private List<Competence> competences;
	@JsonView(Views.ViewCommon.class)
	private List<Skeelz> skeelzs;

	public PersonneDTO() {
		super();
	}

	public List<Skeelz> getSkeelzs() {
		return skeelzs;
	}

	public void setSkeelzs(List<Skeelz> skeelzs) {
		this.skeelzs = skeelzs;
	}

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

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

}
