package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

public class Skeelz {
	
	private Long id;
	private int version;
	private String intitule;
	private int note;
	private String intituleSucces;
	private List<BilanCompetence> bilanCompetence = new ArrayList<BilanCompetence>();
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
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public String getIntituleSucces() {
		return intituleSucces;
	}
	public void setIntituleSucces(String intituleSucces) {
		this.intituleSucces = intituleSucces;
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
