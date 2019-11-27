package sopra.skeelz.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Competence {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(nullable = false, unique = true)
	@JsonView(Views.ViewCommon.class)
	private String intitule;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	@JsonView(Views.ViewCommon.class)
	private Ponderation ponderation;
	private String description;
	@OneToMany(mappedBy = "competence")
	private List<CompetenceSkeelz> competenceSkeelz = new ArrayList<CompetenceSkeelz>();
	@OneToMany(mappedBy = "competence")
	private List<CoursCompetence> coursCompetence = new ArrayList<CoursCompetence>();
	@OneToMany(mappedBy = "competence")
	private List<BilanCompetence> bilanCompetence = new ArrayList<BilanCompetence>();
	
	@ManyToOne
	@JoinColumn(name = "entreprise_id")
	private Entreprise entreprise;

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

	public Ponderation getPonderation() {
		return ponderation;
	}

	public void setPonderation(Ponderation ponderation) {
		this.ponderation = ponderation;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<CompetenceSkeelz> getCompetenceSkeelz() {
		return competenceSkeelz;
	}

	public void setCompetenceSkeelz(List<CompetenceSkeelz> competenceSkeelz) {
		this.competenceSkeelz = competenceSkeelz;
	}

	public List<CoursCompetence> getCoursCompetence() {
		return coursCompetence;
	}

	public void setCoursCompetence(List<CoursCompetence> coursCompetence) {
		this.coursCompetence = coursCompetence;
	}

	public List<BilanCompetence> getBilanCompetence() {
		return bilanCompetence;
	}

	public void setBilanCompetence(List<BilanCompetence> bilanCompetence) {
		this.bilanCompetence = bilanCompetence;
	}

}
