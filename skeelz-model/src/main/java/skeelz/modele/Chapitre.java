package skeelz.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Chapitre")
public class Chapitre {
	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private  String titre;
	private int agencement;
	private List<ElementDeCours> elementsDeCours = new ArrayList<ElementDeCours>();
	
	
	
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

	
	
	
	
	
}
