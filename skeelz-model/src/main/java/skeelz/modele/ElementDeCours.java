package skeelz.modele;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;


@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "chapitre_id", "agencement"})})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public class ElementDeCours{
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private int agencement;
	@ManyToOne
	@JoinColumn(name = "chapitre_id")
	private Chapitre chapitre;
	
	
	
	public ElementDeCours() {
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
	public int getAgencement() {
		return agencement;
	}
	public void setAgencement(int agencement) {
		this.agencement = agencement;
	}


	public Chapitre getChapitre() {
		return chapitre;
	}


	public void setChapitre(Chapitre chapitre) {
		this.chapitre = chapitre;
	}
	
	
	
	
	

}
