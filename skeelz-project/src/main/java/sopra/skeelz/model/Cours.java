package sopra.skeelz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Cours {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCours.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCours.class)
	private int version;
	@Column(nullable = false, unique = true)
	@JsonView(Views.ViewCours.class)
	private String intitule;
	@Column(nullable = false)
	@JsonView(Views.ViewCours.class)
	private String description;
	@JsonView(Views.ViewCours.class)
	private String cheminImageCours;
	@Column(nullable = false)
	@JsonView(Views.ViewCours.class)
	private int duree;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonView(Views.ViewCours.class)
	private Difficulte difficulte;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonView(Views.ViewCours.class)
	private Etat etat;
	@OneToMany(mappedBy = "cours")
	@JsonView(Views.ViewCoursDetail.class)
	private List<CoursCompetence> coursCompetences = new ArrayList<CoursCompetence>();
	@OneToMany(mappedBy = "cours")
	@JsonView(Views.ViewCoursDetail.class)
	private List<Module> modules = new ArrayList<Module>();
	@OneToMany(mappedBy = "cours")
	@JsonView(Views.ViewCoursDetail.class)
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



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public String getCheminImageCours() {
		return cheminImageCours;
	}



	public void setCheminImageCours(String cheminImageCours) {
		this.cheminImageCours = cheminImageCours;
	}
	
	


}
