package sopra.skeelz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "numeroSiret" }) })
public class Entreprise {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private String numeroSiret;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private String typeContrat;

	@OneToMany(mappedBy = "entreprise")
	private List<Utilisateur> administrateur = new ArrayList<Utilisateur>();
	@OneToMany(mappedBy = "entreprise")
	private List<Skeelz> skeelzs = new ArrayList<Skeelz>();
	@OneToMany(mappedBy = "entreprise")
	private List<Cours> courss = new ArrayList<Cours>();
	@OneToMany(mappedBy = "entreprise")
	private List<Competence> competences = new ArrayList<Competence>();

	public Entreprise() {
		super();
	}

	public List<Skeelz> getSkeelzs() {
		return skeelzs;
	}

	public void setSkeelzs(List<Skeelz> skeelzs) {
		this.skeelzs = skeelzs;
	}

	public List<Cours> getCourss() {
		return courss;
	}

	public void setCourss(List<Cours> courss) {
		this.courss = courss;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
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
