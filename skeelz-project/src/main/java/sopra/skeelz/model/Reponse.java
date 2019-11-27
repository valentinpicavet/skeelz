package sopra.skeelz.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
@Table
public class Reponse {
	
	@Id
	@JsonView(Views.ViewCommon.class)
	@GeneratedValue
	private Long id;
	@JsonView(Views.ViewCommon.class)
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	@Column(nullable = false)
	private String enonce;
	@Column(nullable = false)
	@JsonView(Views.ViewCommon.class)
	private boolean juste;
	@ManyToOne
	@JoinColumn(name="question_id")//, nullable = false)
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
