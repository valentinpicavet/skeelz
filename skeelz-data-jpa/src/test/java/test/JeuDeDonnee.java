package test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import Singleton.Singleton;
import repository.IBilanCompetenceRepository;
import repository.IChapitreRepository;
import repository.ICompetenceRepository;
import repository.ICompetenceSkeelzRepository;
import repository.ICoursCompetenceRepository;
import repository.ICoursPersonneRepository;
import repository.ICoursRepository;
import repository.IElementDeCoursRepository;
import repository.IEntrepriseRepository;
import repository.IModuleRepository;
import repository.IPersonneRepository;
import repository.IQCMPersonneRepository;
import repository.IQuestionRepository;
import repository.IReponseRepository;
import repository.ISkeelzRepository;
import repository.IUtilisateurRepository;
import skeelz.modele.BilanCompetence;
import skeelz.modele.Chapitre;
import skeelz.modele.Competence;
import skeelz.modele.CompetenceSkeelz;
import skeelz.modele.Cours;
import skeelz.modele.CoursCompetence;
import skeelz.modele.CoursPersonne;
import skeelz.modele.Difficulte;
import skeelz.modele.Entreprise;
import skeelz.modele.Etat;
import skeelz.modele.EtatCours;
import skeelz.modele.Module;
import skeelz.modele.Paragraphe;
import skeelz.modele.Personne;
import skeelz.modele.Ponderation;
import skeelz.modele.QCMPersonne;
import skeelz.modele.Question;
import skeelz.modele.RelationCours;
import skeelz.modele.Reponse;
import skeelz.modele.Skeelz;
import skeelz.modele.Utilisateur;

public class JeuDeDonnee {

	public static void main(String[] args) throws ParseException {
		
		IBilanCompetenceRepository bilanCompetenceRepo = Singleton.getInstance().getBilanCompetenceRepo();
		IChapitreRepository chapitreRepo = Singleton.getInstance().getChapitreRepo();
		ICompetenceRepository competenceRepo = Singleton.getInstance().getCompetenceRepo();
		ICompetenceSkeelzRepository competenceSkeelzRepo = Singleton.getInstance().getCompetenceSkeelzRepo();
		ICoursCompetenceRepository coursCompetenceRepo = Singleton.getInstance().getCoursCompetenceRepo();
		ICoursPersonneRepository coursPersonneRepo = Singleton.getInstance().getCoursPersonneRepo();
		ICoursRepository coursRepo = Singleton.getInstance().getCoursRepo();
		IElementDeCoursRepository elementDeCoursRepo = Singleton.getInstance().getElementDeCoursRepo();
		IEntrepriseRepository entrepriseRepo = Singleton.getInstance().getEntrepriseRepo();
		IModuleRepository moduleRepo = Singleton.getInstance().getModuleRepo();
		IPersonneRepository personneRepo = Singleton.getInstance().getPersonneRepo();
		IQCMPersonneRepository qcmPersonneRepo =  Singleton.getInstance().getQcmPersonneRepo();
		IQuestionRepository questionRepo = Singleton.getInstance().getQuestionRepo();
		IReponseRepository reponseRepo = Singleton.getInstance().getReponseRepo();
		ISkeelzRepository skeelzRepo = Singleton.getInstance().getSkeelzRepo();	
		IUtilisateurRepository utilisateurRepo = Singleton.getInstance().getUtilisateurRepo();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Skeelz skeelz1 = new Skeelz ();
		skeelz1.setIntitule("Skeelz 1 test");
		skeelz1 = skeelzRepo.save(skeelz1);		
		
		Competence maCompetence = new Competence();
		maCompetence.setDescription("trop bien");
		maCompetence.setIntitule("java pour les null");
		maCompetence.setPonderation(Ponderation.DIX);	
		maCompetence = competenceRepo.save(maCompetence);
		
		CompetenceSkeelz comps = new CompetenceSkeelz();
		comps.setCompetence(maCompetence);
		comps.setSkeelz(skeelz1);
		comps = competenceSkeelzRepo.save(comps);
		
		Entreprise sopra = new Entreprise();
		sopra.setNom("Sopra Steria");
		sopra.setNumeroSiret("ST0045");
		sopra.setTypeContrat("Contrat de ouf");	
		sopra = entrepriseRepo.save(sopra);
		
		Personne maPersonne = new Personne();
		maPersonne.setNom("JEAN");
		maPersonne.setPrenom("Jean");
		maPersonne.setTelephone("026134515");	
		maPersonne = personneRepo.save(maPersonne);
		
		BilanCompetence monBilan = new BilanCompetence();
		monBilan.setCompetence(maCompetence);
		monBilan.setSkeelz(skeelz1);
		monBilan.setPersonne(maPersonne);
		monBilan = bilanCompetenceRepo.save(monBilan);
		
		Utilisateur user = new Utilisateur();
		user.setIdentifiant("Damien");
		user.setMail("damien@yahoo.fr");
		user.setAdministrateur(false);
		user.setPassword("dede");
		user.setRh(false);
		user.setSuperUser(false);
		user.setPersonne(maPersonne);
		user.setEntreprise(sopra);
		user = utilisateurRepo.save(user);
			
		Cours cours1 = new Cours ();
		cours1.setIntitule("java debutant");
		cours1.setDifficulte(Difficulte.FACILE);
		cours1.setDuree(5);
		cours1.setEtat(Etat.OUVERT);
		cours1.setDescription("Apprenez les bases du langage de programmation le plus utilisé dans le monde");
		cours1 = coursRepo.save(cours1);
		
		CoursCompetence monCoursComp = new CoursCompetence();
		monCoursComp.setRelationCours(RelationCours.VALIDE);
		monCoursComp.setCours(cours1);
		monCoursComp.setCompetence(maCompetence);
		monCoursComp = coursCompetenceRepo.save(monCoursComp);
		
		CoursPersonne monCoursPers = new CoursPersonne();
		monCoursPers.setEtatCours(EtatCours.VALIDE);
		monCoursPers.setCours(cours1);
		monCoursPers.setPersonne(maPersonne);
		monCoursPers = coursPersonneRepo.save(monCoursPers);
		
		Module javas = new Module();
		javas.setIntitule("Java");
		javas.setAgencement(0);
		javas.setNbQuestion(2);
		javas.setPeriodicite(1);
		javas.setNbTentativeAutorise(3);
		javas.setCours(cours1);
		javas = moduleRepo.save(javas);
		
		QCMPersonne qcm = new QCMPersonne();
		qcm.setStatutQCM(true);
		qcm.setDateDerniereTentative(sdf.parse("02/02/02"));
		qcm.setModule(javas);
		qcm.setPersonne(maPersonne);
		qcm = qcmPersonneRepo.save(qcm);
		
		Question javaAlgoquest1 = new Question();
		javaAlgoquest1.setQuestion("Comment se nomme la variable des chaines de caratères ?");
		javaAlgoquest1.setModule(javas);
		javaAlgoquest1 = questionRepo.save(javaAlgoquest1);
		
		Question javaAlgoquest2 = new Question();
		javaAlgoquest2.setQuestion("Comment se nomme la variable des entiers ?");
		javaAlgoquest2.setModule(javas);
		javaAlgoquest2 = questionRepo.save(javaAlgoquest2);
		
		
		Reponse javaAlgorep1 = new Reponse();
		javaAlgorep1.setEnonce("String");
		javaAlgorep1.setQuestion(javaAlgoquest1);
		javaAlgorep1.setJuste(true);
		javaAlgorep1 = reponseRepo.save(javaAlgorep1);
		
		Reponse javaAlgorep2 = new Reponse();
		javaAlgorep2.setEnonce("string");
		javaAlgorep2.setQuestion(javaAlgoquest1);
		javaAlgorep2.setJuste(false);
		javaAlgorep2 = reponseRepo.save(javaAlgorep2);
		
		Reponse javaAlgorep3 = new Reponse();
		javaAlgorep3.setEnonce("int");
		javaAlgorep3.setQuestion(javaAlgoquest1);
		javaAlgorep3.setJuste(false);
		javaAlgorep3 = reponseRepo.save(javaAlgorep3);
		
		Reponse javaAlgorep4 = new Reponse();
		javaAlgorep4.setEnonce("String");
		javaAlgorep4.setQuestion(javaAlgoquest2);
		javaAlgorep4.setJuste(false);
		javaAlgorep4 = reponseRepo.save(javaAlgorep4);
		
		Reponse javaAlgorep5 = new Reponse();
		javaAlgorep5.setEnonce("string");
		javaAlgorep5.setQuestion(javaAlgoquest2);
		javaAlgorep5.setJuste(false);
		javaAlgorep5 = reponseRepo.save(javaAlgorep5);
		
		Reponse javaAlgorep6 = new Reponse();
		javaAlgorep6.setEnonce("int");
		javaAlgorep6.setQuestion(javaAlgoquest2);
		javaAlgorep6.setJuste(true);
		javaAlgorep6 = reponseRepo.save(javaAlgorep6);
		
		Chapitre javaAlgo = new Chapitre();
		javaAlgo.setTitre("Java Algo");
		javaAlgo.setAgencement(0);
		javaAlgo.setModule(javas);
		javaAlgo = chapitreRepo.save(javaAlgo);

		Paragraphe monElement = new Paragraphe();
		monElement.setAgencement(0);
		monElement.setTexte("ceci est un paragraphe");
		monElement.setTitre("paragraphe");	
		monElement.setChapitre(javaAlgo);
		monElement = (Paragraphe) elementDeCoursRepo.save(monElement);
		
		Paragraphe monElement2 = new Paragraphe();
		monElement2.setAgencement(1);
		monElement2.setTexte("ceci est un paragraphe ausse");
		monElement2.setTitre("paragraphe2");	
		monElement2.setChapitre(javaAlgo);
		monElement2 = (Paragraphe) elementDeCoursRepo.save(monElement2);
	}

}
