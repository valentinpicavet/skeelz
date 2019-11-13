package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

public class Cours {
	private Long id;
	private int version;
	private String intitule;
	private int duree;
	private Difficulte difficulte;
	private Etat etat;
	private List<CoursCompetence> coursCompetences = new ArrayList<CoursCompetence>();
	private List<Module> modules = new ArrayList<Module>();
	private List<CoursPersonne> coursPersonnes = new ArrayList<CoursPersonne>();
	
	
	
	
	public Cours() {
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
	public int getDuree() {
		return duree;
	}
	public void setDuree(int duree) {
		this.duree = duree;
	}
	public Difficulte getDifficulte() {
		return difficulte;
	}
	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public List<CoursCompetence> getCoursCompetences() {
		return coursCompetences;
	}
	public void setCoursCompetences(List<CoursCompetence> coursCompetences) {
		this.coursCompetences = coursCompetences;
	}
	public List<Module> getModules() {
		return modules;
	}
	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	public List<CoursPersonne> getCoursPersonnes() {
		return coursPersonnes;
	}
	public void setCoursPersonnes(List<CoursPersonne> coursPersonnes) {
		this.coursPersonnes = coursPersonnes;
	}
	
	


}
