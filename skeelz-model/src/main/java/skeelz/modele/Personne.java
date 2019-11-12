package skeelz.modele;

import java.util.ArrayList;
import java.util.List;


public class Personne {

		private Long id;
		private int version;
		private String nom;
		private String prenom;
		private String mail;
		private String password;
		private String identifiant;
		private String telephone;
		private boolean administrateur;
		private boolean rh;
		private int noteGlobal;
		private List<Competence> competences = new ArrayList<Competence>();
		private List<Cours> cours = new ArrayList<Cours>();
		private Difficulte difficulte;
		

}
