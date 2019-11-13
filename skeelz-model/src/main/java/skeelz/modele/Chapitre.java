package skeelz.modele;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Chapitre {
	@Id
	@GeneratedValue
	private Long id;
	private int version;
	private  String titre;
	private int agencement;
	
}
