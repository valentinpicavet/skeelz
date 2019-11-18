package test;

import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


import repository.IChapitreRepository;
import repository.ICompetenceRepository;
import repository.ICompetenceSkeelzRepository;
import repository.IModuleRepository;
import repository.IPersonneRepository;
import repository.IQCMPersonneRepository;
import repository.IQuestionRepository;
import repository.IReponseRepository;
import repository.ISkeelzRepository;
import repository.IUtilisateurRepository;
import skeelz.modele.Chapitre;
import skeelz.modele.Competence;
import skeelz.modele.CompetenceSkeelz;
import skeelz.modele.Module;
import skeelz.modele.Personne;
import skeelz.modele.Ponderation;
import skeelz.modele.QCMPersonne;
import skeelz.modele.Question;
import skeelz.modele.Reponse;
import skeelz.modele.Skeelz;
import skeelz.modele.Utilisateur;

public class TestJpaRepoDam {

	public static void main(String[] args) {
//		IChapitreRepository chapitrerepo = Singleton.getInstance().getChapitreRepo();
//		IModuleRepository modulerepo = Singleton.getInstance().getModuleRepo();
//		IReponseRepository reponserepo = Singleton.getInstance().getReponseRepo();
//		IQuestionRepository questionrepo = Singleton.getInstance().getQuestionRepo();
//		IQCMPersonneRepository qcmpersonne =  Singleton.getInstance().getQcmPersonneRepo();
//		IPersonneRepository personneRepo = Singleton.getInstance().getPersonneRepo();
//		IUtilisateurRepository utilisateurrepo = Singleton.getInstance().getUtilisateurRepo();
//
//		ICompetenceSkeelzRepository comptenceskeelzrepo = Singleton.getInstance().getCompetenceSkeelzRepo();
//		ICompetenceRepository competencerepo = Singleton.getInstance().getCompetenceRepo();
//		ISkeelzRepository skeelzrepo = Singleton.getInstance().getSkeelzRepo();
//
//		Competence jpa = new Competence();
//		jpa.setIntitule("JPA");
//		
//		jpa.setPonderation(Ponderation.DIX);
//		jpa = competencerepo.save(jpa);
//
//		Skeelz java = new Skeelz();
//		java.setIntitule("java");
//		skeelzrepo.save(java);
//
//		Skeelz basedonnee = new Skeelz();
//		basedonnee.setIntitule("Base de Données");
//		skeelzrepo.save(basedonnee);
//
//		CompetenceSkeelz javaJpa = new CompetenceSkeelz();
//
//		javaJpa.setSkeelz(java);
//
//
//
//		Personne maPersonne = new Personne();
//		maPersonne.setNom("JEAN");
//		maPersonne.setPrenom("Jean");
//		maPersonne.setTelephone("026134515");
//		maPersonne = personneRepo.save(maPersonne);
//		
//		Utilisateur jean = new Utilisateur();
//		jean.setPassword("password");
//		jean.setIdentifiant("lebeaugosse33");
//		jean.setMail("michel.delpech@gmail.com");
//		jean.setPersonne(maPersonne);
//		jean = utilisateurrepo.save(jean);
//
//	
//		
//		Module javas = new Module();
//		java.setIntitule("Java");
//		javas = modulerepo.save(javas);
//		
//
//		
//		
//		QCMPersonne qcm = new QCMPersonne();
//		qcm.setStatutQCM(true);
//
//		qcm.setModule(javas);
//		qcm.setPersonne(maPersonne);
//		qcm = qcmpersonne.save(qcm);
//
//		qcm.setModule(javas);
//		qcm.setPersonne(maPersonne);
//		qcmpersonne.save(qcm);
//
//		
//		Question javaAlgoquest = new Question();
//		javaAlgoquest.setQuestion("qui a la plus grosse bite ?");
//		javaAlgoquest.setModule(javas);
//		javaAlgoquest = questionrepo.save(javaAlgoquest);
//		
//		
//		Reponse javaAlgorepd = new Reponse();
//		javaAlgorepd.setEnonce("Damien");
//		javaAlgorepd.setQuestion(javaAlgoquest);
//		javaAlgorepd.setJuste(true);
//		javaAlgorepd = reponserepo.save(javaAlgorepd);
//		
//		Reponse javaAlgorepvin = new Reponse();
//		javaAlgorepvin.setEnonce("Vincent");
//		javaAlgorepvin.setQuestion(javaAlgoquest);
//		javaAlgorepvin.setJuste(false);
//		javaAlgorepvin = reponserepo.save(javaAlgorepvin);
//		
//		
//		Chapitre javaAlgo = new Chapitre();
//		javaAlgo.setTitre("Java Algo");
//		javaAlgo.setModule(javas);
//		javaAlgo = chapitrerepo.save(javaAlgo);
//		
//		
//		Reponse javaAlgorepdf = reponserepo.find(javaAlgorepd.getId());
//		Question javaAlgoquestf = questionrepo.find(javaAlgoquest.getId());
//		List<Chapitre> javaAlgofall = chapitrerepo.findAll();
//		List<Module> javafall = modulerepo.findAll();
//		
//		
//		Chapitre javaAlgof = chapitrerepo.find(javaAlgo.getId());
//		Module javaf = modulerepo.find(java.getId());
//		List<Reponse> javaAlgorepdall = reponserepo.findAll();
//		List<Question> javaAlgoquestall = questionrepo.findAll();
//		
//		
//		
//		reponserepo.delete(javaAlgorepvin);
//		questionrepo.delete(javaAlgoquest);
//		
//		chapitrerepo.delete(javaAlgo);
//		modulerepo.delete(javas);
//		
//		System.out.println(javaAlgof);
//		System.out.println(javaf);
//		System.out.println(javaAlgofall);
//		System.out.println(javafall);
//		System.out.println(javaAlgorepdf);
//		System.out.println(javaAlgoquestf);
//		System.out.println(javaAlgorepdall);
//		System.out.println(javaAlgoquestall);

	}

}
