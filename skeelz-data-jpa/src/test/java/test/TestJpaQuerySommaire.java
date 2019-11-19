package test;

import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import repository.IChapitreRepository;
import repository.ICoursRepository;
import repository.IModuleRepository;
import skeelz.modele.Chapitre;
import skeelz.modele.Cours;
import skeelz.modele.Difficulte;
import skeelz.modele.Etat;
import skeelz.modele.Module;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/application-context.xml")
public class TestJpaQuerySommaire {

	@Autowired
	private ICoursRepository coursRepo;
	@Autowired
	private IModuleRepository moduleRepo;
	@Autowired
	private IChapitreRepository chapitreRepo;

	@Test
	public void testCours() {


		Cours detecteurFume = new Cours ();
		detecteurFume.setIntitule("Concevez un détecteur de fumée connecté");
		detecteurFume.setDifficulte(Difficulte.FACILE);
		detecteurFume.setDuree(6);
		detecteurFume.setEtat(Etat.OUVERT);
		detecteurFume.setDescription("Dans ce cours, vous allez découvrir comment concevoir un objet connecté simple dans son contexte opérationnel : un détecteur de fumée connecté, depuis la définition des besoins jusqu’au prototypage.");
		detecteurFume.setCheminImageCours("Le chemin");
		detecteurFume = coursRepo.save(detecteurFume);
		
		Module definition = new Module();
		definition.setIntitule("Définissez votre projet de détecteur de fumée connecté");
		definition.setAgencement(1);
		definition.setNbQuestion(11);
		definition.setPeriodicite(1);
		definition.setNbTentativeAutorise(3);
		definition.setEnonceQCM("Définissez votre projet de détecteur de fumée connecté");
		definition.setCours(detecteurFume);
		definition = moduleRepo.save(definition);
		
		Chapitre detect11 = new Chapitre();
		detect11.setTitre("Découvrez le domaine des systèmes embarqués et objets connectés");
		detect11.setAgencement(0);
		detect11.setModule(definition);
		detect11 = chapitreRepo.save(detect11);
		
		Chapitre detect12 = new Chapitre();
		detect12.setTitre("Découvrez notre cas d'étude : le détecteur de fumée connecté");
		detect12.setAgencement(1);
		detect12.setModule(definition);
		detect12 = chapitreRepo.save(detect12);
		
		Module approfondissement = new Module();
		approfondissement.setIntitule("Approfondissez le développement de votre projet par des analyse métiers");
		approfondissement.setAgencement(2);
		approfondissement.setNbQuestion(3);
		approfondissement.setPeriodicite(1);
		approfondissement.setNbTentativeAutorise(3);
		approfondissement.setEnonceQCM("Approfondissez le développement de votre projet par des analyse métiers");
		approfondissement.setCours(detecteurFume);
		approfondissement = moduleRepo.save(approfondissement);
		
		Chapitre detect21 = new Chapitre();
		detect21.setTitre("Alimentez votre système d'énergie");
		detect21.setAgencement(0);
		detect21.setModule(approfondissement);
		detect21 = chapitreRepo.save(detect21);
		
		Chapitre detect22 = new Chapitre();
		detect22.setTitre("Optimisez l'ergonomie du système");
		detect22.setAgencement(1);
		detect22.setModule(approfondissement);
		detect22 = chapitreRepo.save(detect22);
		
		Cours javaDebutant = new Cours ();
		javaDebutant.setIntitule("Apprenez les bases de java");
		javaDebutant.setDifficulte(Difficulte.FACILE);
		javaDebutant.setDuree(5);
		javaDebutant.setEtat(Etat.OUVERT);
		javaDebutant.setDescription("Dans ce cours, vous allez apprendre les bases du langage de programmation le plus utilisé au monde");
		javaDebutant.setCheminImageCours("Le chemin");
		javaDebutant = coursRepo.save(javaDebutant);
		
		Module introduction = new Module();
		introduction.setIntitule("Introduction à la syntaxe Java");
		introduction.setAgencement(1);
		introduction.setNbQuestion(5);
		introduction.setPeriodicite(1);
		introduction.setNbTentativeAutorise(3);
		introduction.setEnonceQCM("Syntaxe de base");
		introduction.setCours(javaDebutant);
		introduction = moduleRepo.save(introduction);
		
		Chapitre java11 = new Chapitre();
		java11.setTitre("Les types de variable");
		java11.setAgencement(0);
		java11.setModule(introduction);
		java11 = chapitreRepo.save(java11);
		
		Chapitre java12 = new Chapitre();
		java12.setTitre("La déclaration des variables");
		java12.setAgencement(1);
		java12.setModule(introduction);
		java12 = chapitreRepo.save(java12);
		
		Module lesBoucles = new Module();
		lesBoucles.setIntitule("Découvrez les boucles de base");
		lesBoucles.setAgencement(2);
		lesBoucles.setNbQuestion(3);
		lesBoucles.setPeriodicite(1);
		lesBoucles.setNbTentativeAutorise(3);
		lesBoucles.setEnonceQCM("Les boucles de base");
		lesBoucles.setCours(javaDebutant);
		lesBoucles = moduleRepo.save(lesBoucles);
		
		Chapitre java21 = new Chapitre();
		java21.setTitre("Les boucles while");
		java21.setAgencement(0);
		java21.setModule(lesBoucles);
		java21 = chapitreRepo.save(java21);
		
		Chapitre java22 = new Chapitre();
		java22.setTitre("Les boucles for");
		java22.setAgencement(1);
		java22.setModule(lesBoucles);
		java22 = chapitreRepo.save(java22);
				
		int nbModule = moduleRepo.findAllByCours(detecteurFume).size();
		
		int nbChapitre = chapitreRepo.findAllByCours(detecteurFume).size();
		
		int nbChapitreDansModule = chapitreRepo.findAllByModule(definition).size();
		
		int nbModulesAvecChapitres = moduleRepo.findAllByCoursWithChapitres(detecteurFume).size();
		
		Assert.assertEquals(2, nbModule);
		
		Assert.assertEquals(4, nbChapitre);
		
		Assert.assertEquals(2, nbChapitreDansModule);
		
		Assert.assertEquals(4, nbModulesAvecChapitres);
		
		

	}

}
