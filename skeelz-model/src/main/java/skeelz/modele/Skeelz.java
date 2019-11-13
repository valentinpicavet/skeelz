package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

@Entity
public class Skeelz {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false, unique = true)
	private String intitule;
	@OneToMany(mappedBy = "skeelz")
	private List<BilanCompetence> bilanCompetence = new ArrayList<BilanCompetence>();
	@OneToMany(mappedBy = "skeelz")
	private List<CompetenceSkeelz> competenceSkeelz = new ArrayList<CompetenceSkeelz>();

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

	public List<BilanCompetence> getBilanCompetence() {
		return bilanCompetence;
	}

	public void setBilanCompetence(List<BilanCompetence> bilanCompetence) {
		this.bilanCompetence = bilanCompetence;
	}

	public List<CompetenceSkeelz> getCompetenceSkeelz() {
		return competenceSkeelz;
	}

	public void setCompetenceSkeelz(List<CompetenceSkeelz> competenceSkeelz) {
		this.competenceSkeelz = competenceSkeelz;
	}

}
