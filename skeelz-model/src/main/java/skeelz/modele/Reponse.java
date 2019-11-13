package skeelz.modele;

public class Reponse {
	private Long id;
	private int version;
	private String enonce;
	private boolean juste;
	private Question question;
	
	
	
	
	public Reponse() {
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
	public String getEnonce() {
		return enonce;
	}
	public void setEnonce(String enonce) {
		this.enonce = enonce;
	}
	public boolean isJuste() {
		return juste;
	}
	public void setJuste(boolean juste) {
		this.juste = juste;
	}
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}

	
	
}
