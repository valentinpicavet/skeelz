package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

public class Question {
	private Long id;
	private int version;
	private String question;
	private Module module;
	private List<Reponse> reponses = new ArrayList<Reponse>();
	
	
	
	
	public Question() {
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
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Module getModule() {
		return module;
	}
	public void setModule(Module module) {
		this.module = module;
	}
	public List<Reponse> getReponses() {
		return reponses;
	}
	public void setReponses(List<Reponse> reponses) {
		this.reponses = reponses;
	}

	
	
}
