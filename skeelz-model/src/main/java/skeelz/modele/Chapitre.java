package skeelz.modele;

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

@Entity
@Table(uniqueConstraints= {@UniqueConstraint(columnNames = { "module_id", "titre"}), @UniqueConstraint(columnNames = { "module_id", "agencement"})})
public class Chapitre {
	@Id
	@GeneratedValue
	private Long id;
	@Version
	private int version;
	@Column(nullable = false)
	private  String titre;
	@Column(nullable = false)
	private int agencement;
	@OneToMany(mappedBy = "chapitre")
	private List<ElementDeCours> elementsDeCours = new ArrayList<ElementDeCours>();
	@ManyToOne
	@JoinColumn(name="module_id")
	private Module module;
	
	
	
	public Chapitre() {
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
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public int getAgencement() {
		return agencement;
	}
	public void setAgencement(int agencement) {
		this.agencement = agencement;
	}
	public List<ElementDeCours> getElementsDeCours() {
		return elementsDeCours;
	}
	public void setElementsDeCours(List<ElementDeCours> elementsDeCours) {
		this.elementsDeCours = elementsDeCours;
	}


	public Module getModule() {
		return module;
	}


	public void setModule(Module module) {
		this.module = module;
	}

	
	
	
	
	
}
