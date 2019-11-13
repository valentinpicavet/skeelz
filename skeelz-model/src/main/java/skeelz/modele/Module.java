package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

public class Module {
	private Long id;
	private int version;
	private String intitule;
	private int agencement;
	private  int nbQuestion;
	private int periodicite;
	private int nbTentativeAutorise;
	private List<Question> questions = new ArrayList<Question>();
	private List<Chapitre> chapitres = new ArrayList<Chapitre>();
	private List<QCMPersonne> qcmPersonnes = new ArrayList<QCMPersonne>();
	private Cours cours;
	

	
	public Module() {
		super();
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
	public String getIntitule() {
		return intitule;
	}
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	public int getAgencement() {
		return agencement;
	}
	public void setAgencement(int agencement) {
		this.agencement = agencement;
	}
	public int getNbQuestion() {
		return nbQuestion;
	}
	public void setNbQuestion(int nbQuestion) {
		this.nbQuestion = nbQuestion;
	}
	public int getPeriodicite() {
		return periodicite;
	}
	public void setPeriodicite(int periodicite) {
		this.periodicite = periodicite;
	}
	public int getNbTentativeAutorise() {
		return nbTentativeAutorise;
	}
	public void setNbTentativeAutorise(int nbTentativeAutorise) {
		this.nbTentativeAutorise = nbTentativeAutorise;
	}
	public List<Question> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}
	public List<Chapitre> getChapitres() {
		return chapitres;
	}
	public void setChapitres(List<Chapitre> chapitres) {
		this.chapitres = chapitres;
	}
	public List<QCMPersonne> getQcmPersonnes() {
		return qcmPersonnes;
	}
	public void setQcmPersonnes(List<QCMPersonne> qcmPersonnes) {
		this.qcmPersonnes = qcmPersonnes;
	}
	public Cours getCours() {
		return cours;
	}
	public void setCours(Cours cours) {
		this.cours = cours;
	}
	
	
	
	
	
}
