package sopra.skeelz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;




@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "cours_id", "intitule"}), @UniqueConstraint(columnNames = { "cours_id", "agencement"})})
public class Module {
	
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private String intitule;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private int agencement;
	@JsonView(Views.ViewCommon.class)
	private String enonceQCM;
	@JsonView(Views.ViewCommon.class)
	private  int nbQuestion;
	@JsonView(Views.ViewCommon.class)
	private int periodicite;
	@JsonView(Views.ViewCommon.class)
	private int nbTentativeAutorise;
	
	
	
	@OneToMany(mappedBy = "module")
	private List<Question> questions = new ArrayList<Question>();
	@OneToMany(mappedBy = "module")
	private List<Chapitre> chapitres = new ArrayList<Chapitre>();
	@OneToMany(mappedBy = "module")
	private List<QCMPersonne> qcmPersonnes = new ArrayList<QCMPersonne>();
	@ManyToOne
	@JoinColumn(name ="cours_id")//, nullable = false)
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


	public String getEnonceQCM() {
		return enonceQCM;
	}


	public void setEnonceQCM(String enonceQCM) {
		this.enonceQCM = enonceQCM;
	}
	
	
	
	
	
}
