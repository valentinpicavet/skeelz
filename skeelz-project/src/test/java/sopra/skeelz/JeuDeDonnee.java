package sopra.skeelz;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.Module;
import sopra.skeelz.model.Paragraphe;
import sopra.skeelz.model.Personne;
import sopra.skeelz.model.Ponderation;
import sopra.skeelz.model.QCMPersonne;
import sopra.skeelz.model.Question;
import sopra.skeelz.model.RelationCours;
import sopra.skeelz.model.Reponse;
import sopra.skeelz.model.Skeelz;
import sopra.skeelz.model.Utilisateur;
import sopra.skeelz.repository.IBilanCompetenceRepository;
import sopra.skeelz.repository.IChapitreRepository;
import sopra.skeelz.repository.ICompetenceRepository;
import sopra.skeelz.repository.ICompetenceSkeelzRepository;
import sopra.skeelz.repository.ICoursCompetenceRepository;
import sopra.skeelz.repository.ICoursPersonneRepository;
import sopra.skeelz.repository.ICoursRepository;
import sopra.skeelz.repository.IElementDeCoursRepository;
import sopra.skeelz.repository.IEntrepriseRepository;
import sopra.skeelz.repository.IModuleRepository;
import sopra.skeelz.repository.IPersonneRepository;
import sopra.skeelz.repository.IQCMPersonneRepository;
import sopra.skeelz.repository.IQuestionRepository;
import sopra.skeelz.repository.IReponseRepository;
import sopra.skeelz.repository.ISkeelzRepository;
import sopra.skeelz.repository.IUtilisateurRepository;

@SpringBootTest
public class JeuDeDonnee {

	@Autowired
	IBilanCompetenceRepository bilanCompetenceRepo;
	@Autowired
	IChapitreRepository chapitreRepo;
	@Autowired
	ICompetenceRepository competenceRepo;
	@Autowired
	ICompetenceSkeelzRepository competenceSkeelzRepo;
	@Autowired
	ICoursCompetenceRepository coursCompetenceRepo;
	@Autowired
	ICoursPersonneRepository coursPersonneRepo;
	@Autowired
	ICoursRepository coursRepo;
	@Autowired
	IElementDeCoursRepository elementDeCoursRepo;
	@Autowired
	IEntrepriseRepository entrepriseRepo;
	@Autowired
	IModuleRepository moduleRepo;
	@Autowired
	IPersonneRepository personneRepo;
	@Autowired
	IQCMPersonneRepository qcmPersonneRepo;
	@Autowired
	IQuestionRepository questionRepo;
	@Autowired
	IReponseRepository reponseRepo;
	@Autowired
	ISkeelzRepository skeelzRepo;
	@Autowired
	IUtilisateurRepository utilisateurRepo;

	@Test
	void jeuDeDonnees() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Entreprise sopra = new Entreprise();
		sopra.setNom("Sopra Steria");
		sopra.setNumeroSiret("ST0045");
		sopra.setTypeContrat("Contrat de ouf");
		sopra = entrepriseRepo.save(sopra);

		Skeelz objetConnecte = new Skeelz();
		objetConnecte.setIntitule("Objet Connecté");
		objetConnecte.setEntreprise(sopra);
		objetConnecte = skeelzRepo.save(objetConnecte);

		Competence developpementDetecteurFume = new Competence();
		developpementDetecteurFume.setDescription("Vous êtes capable de concevoir un détécteur de fumées connecté");
		developpementDetecteurFume.setIntitule("Développement d'un détecteur de fumée connecté");
		developpementDetecteurFume.setPonderation(Ponderation.DIX);
		developpementDetecteurFume.setEntreprise(sopra);
		developpementDetecteurFume = competenceRepo.save(developpementDetecteurFume);

		CompetenceSkeelz objetCoDetecteur = new CompetenceSkeelz();
		objetCoDetecteur.setCompetence(developpementDetecteurFume);
		objetCoDetecteur.setSkeelz(objetConnecte);
		objetCoDetecteur = competenceSkeelzRepo.save(objetCoDetecteur);

		Utilisateur userValentin = new Utilisateur();
		userValentin.setIdentifiant("Valentin");
		userValentin.setMail("valentin@yahoo.fr");
		userValentin.setAdministrateur(false);
		userValentin.setPassword("vp");
		userValentin.setRh(false);
		userValentin.setSuperUser(false);
		userValentin.setEntreprise(sopra);
		userValentin = utilisateurRepo.save(userValentin);

		Utilisateur userDamien = new Utilisateur();
		userDamien.setIdentifiant("Damien");
		userDamien.setMail("damien@yahoo.fr");
		userDamien.setAdministrateur(true);
		userDamien.setPassword("dl");
		userDamien.setRh(false);
		userDamien.setSuperUser(false);
		userDamien.setEntreprise(sopra);
		userDamien = utilisateurRepo.save(userDamien);

		Utilisateur userArthur = new Utilisateur();
		userArthur.setIdentifiant("Arthur");
		userArthur.setMail("arthur@yahoo.fr");
		userArthur.setAdministrateur(true);
		userArthur.setPassword("dl");
		userArthur.setRh(true);
		userArthur.setSuperUser(false);
		userArthur.setEntreprise(sopra);
		userArthur = utilisateurRepo.save(userArthur);

		Utilisateur userVincent = new Utilisateur();
		userVincent.setIdentifiant("Vincent");
		userVincent.setMail("vincent@yahoo.fr");
		userVincent.setAdministrateur(false);
		userVincent.setPassword("dl");
		userVincent.setRh(false);
		userVincent.setSuperUser(true);
		userVincent.setEntreprise(sopra);
		userVincent = utilisateurRepo.save(userVincent);

		Utilisateur userTheau = new Utilisateur();
		userTheau.setIdentifiant("theau");
		userTheau.setMail("theau@yahoo.fr");
		userTheau.setAdministrateur(false);
		userTheau.setPassword("tp");
		userTheau.setRh(false);
		userTheau.setSuperUser(false);
		userTheau.setEntreprise(sopra);
		userTheau = utilisateurRepo.save(userTheau);

		Personne personneValentin = new Personne();
		personneValentin.setNom("Picavet");
		personneValentin.setPrenom("Valentin");
		personneValentin.setTelephone("0624153698");
		personneValentin.setUtilisateur(userValentin);
		personneValentin = personneRepo.save(personneValentin);

		Personne personneVincent = new Personne();
		personneVincent.setNom("Maridet");
		personneVincent.setPrenom("Vincent");
		personneVincent.setTelephone("0624656698");
		personneVincent.setUtilisateur(userVincent);
		personneVincent = personneRepo.save(personneVincent);

		Personne personneDamien = new Personne();
		personneDamien.setNom("Lignac");
		personneDamien.setPrenom("Damien");
		personneDamien.setTelephone("0624556798");
		personneDamien.setUtilisateur(userDamien);
		personneDamien = personneRepo.save(personneDamien);

		Personne personneArthur = new Personne();
		personneArthur.setNom("Robert");
		personneArthur.setPrenom("Arthur");
		personneArthur.setTelephone("0629526798");
		personneArthur.setUtilisateur(userArthur);
		personneArthur = personneRepo.save(personneArthur);

		Personne personneTheau = new Personne();
		personneTheau.setNom("Poix");
		personneTheau.setPrenom("Théau");
		personneTheau.setTelephone("0624156698");
		personneTheau.setUtilisateur(userTheau);
		personneTheau = personneRepo.save(personneTheau);

		BilanCompetence BilanValDete = new BilanCompetence();
		BilanValDete.setCompetence(developpementDetecteurFume);
		BilanValDete.setSkeelz(objetConnecte);
		BilanValDete.setPersonne(personneValentin);
		BilanValDete = bilanCompetenceRepo.save(BilanValDete);

		Cours detecteurFume = new Cours();
		detecteurFume.setIntitule("Concevez un détecteur de fumée connecté");
		detecteurFume.setDifficulte(Difficulte.FACILE);
		detecteurFume.setDuree(6);
		detecteurFume.setEtat(Etat.OUVERT);
		detecteurFume.setDescription(
				"Dans ce cours, vous allez découvrir comment concevoir un objet connecté simple dans son contexte opérationnel : un détecteur de fumée connecté, depuis la définition des besoins jusqu’au prototypage.");
		detecteurFume.setCheminImageCours("Le chemin");
		detecteurFume.setEntreprise(sopra);
		detecteurFume = coursRepo.save(detecteurFume);

		CoursCompetence detecteurFumeComp = new CoursCompetence();
		detecteurFumeComp.setRelationCours(RelationCours.VALIDE);
		detecteurFumeComp.setCours(detecteurFume);
		detecteurFumeComp.setCompetence(developpementDetecteurFume);
		detecteurFumeComp = coursCompetenceRepo.save(detecteurFumeComp);

		CoursPersonne valentinDetecteur = new CoursPersonne();
		valentinDetecteur.setEtatCours(EtatCours.ADMINISTRE);
		valentinDetecteur.setCours(detecteurFume);
		valentinDetecteur.setPersonne(personneValentin);
		valentinDetecteur = coursPersonneRepo.save(valentinDetecteur);

		CoursPersonne damienDetecteur = new CoursPersonne();
		damienDetecteur.setEtatCours(EtatCours.SUIVI);
		damienDetecteur.setCours(detecteurFume);
		damienDetecteur.setPersonne(personneDamien);
		damienDetecteur = coursPersonneRepo.save(damienDetecteur);

		Module definition = new Module();
		definition.setIntitule("Définissez votre projet de détecteur de fumée connecté");
		definition.setAgencement(1);
		definition.setNbQuestion(11);
		definition.setPeriodicite(1);
		definition.setNbTentativeAutorise(3);
		definition.setEnonceQCM("Définissez votre projet de détecteur de fumée connecté");
		definition.setCours(detecteurFume);
		definition = moduleRepo.save(definition);

		QCMPersonne definitionValentin = new QCMPersonne();
		definitionValentin.setStatutQCM(true);
		definitionValentin.setDateDerniereTentative(sdf.parse("02/02/02"));
		definitionValentin.setModule(definition);
		definitionValentin.setPersonne(personneValentin);
		definitionValentin = qcmPersonneRepo.save(definitionValentin);

		QCMPersonne definitionDamien = new QCMPersonne();
		definitionDamien.setStatutQCM(false);
		definitionDamien.setDateDerniereTentative(sdf.parse("02/02/02"));
		definitionDamien.setModule(definition);
		definitionDamien.setPersonne(personneDamien);
		definitionDamien = qcmPersonneRepo.save(definitionDamien);

		Question def1 = new Question();
		def1.setQuestion("Quel est le problème soulevé par la mise en situation ?");
		def1.setModule(definition);
		def1 = questionRepo.save(def1);

		Question def2 = new Question();
		def2.setQuestion("Quelles propriétés permettent de qualifier un détecteur de fumée de \"système embarqué\" ?");
		def2.setModule(definition);
		def2 = questionRepo.save(def2);

		Question def3 = new Question();
		def3.setQuestion("Quelles considérations faut-il intégrer dans une démarche de développement de système ?");
		def3.setModule(definition);
		def3 = questionRepo.save(def3);

		Question def4 = new Question();
		def4.setQuestion("Penser système, c’est :");
		def4.setModule(definition);
		def4 = questionRepo.save(def4);

		Question def5 = new Question();
		def5.setQuestion("Une partie prenante est : ");
		def5.setModule(definition);
		def5 = questionRepo.save(def5);

		Question def6 = new Question();
		def6.setQuestion(
				"Les parties prenantes dans un projet de développement d’un détecteur de fumée qui sera commercialisé sont :");
		def6.setModule(definition);
		def6 = questionRepo.save(def6);

		Question def7 = new Question();
		def7.setQuestion("Nous avons abordé le système embarqué comme une « boîte noire ». De quoi s’agit-il ?");
		def7.setModule(definition);
		def7 = questionRepo.save(def7);

		Question def8 = new Question();
		def8.setQuestion(
				"Peut-il y avoir plusieurs systèmes d’intérêt autour d’un système embarqué ou d'un objet connecté ?");
		def8.setModule(definition);
		def8 = questionRepo.save(def8);

		Question def9 = new Question();
		def9.setQuestion(
				"Quelles sont les quatre phases du développement d'un objet connecté ou d'un système embarqué ?");
		def9.setModule(definition);
		def9 = questionRepo.save(def9);

		Question def10 = new Question();
		def10.setQuestion(
				"Quel est l'intérêt de faire une analyse fonctionnelle lors du développement d'un objet connecté ou d'un système embarqué ? ");
		def10.setModule(definition);
		def10 = questionRepo.save(def10);

		Question def11 = new Question();
		def11.setQuestion("Sur quels facteurs l'analyse organique influe-t-elle ? (Trois réponses possibles).");
		def11.setModule(definition);
		def11 = questionRepo.save(def11);

		Reponse defquest1resp1 = new Reponse();
		defquest1resp1.setEnonce("Le détecteur de fumée n’a pas fonctionné.");
		defquest1resp1.setQuestion(def1);
		defquest1resp1.setJuste(true);
		defquest1resp1 = reponseRepo.save(defquest1resp1);

		Reponse defquest1resp2 = new Reponse();
		defquest1resp2.setEnonce("Le détecteur de fumée a déclenché une alarme sonore mais personne n’est intervenu.");
		defquest1resp2.setQuestion(def1);
		defquest1resp2.setJuste(false);
		defquest1resp2 = reponseRepo.save(defquest1resp2);

		Reponse defquest1resp3 = new Reponse();
		defquest1resp3.setEnonce("Le détecteur de fumée a bien fonctionné mais Joe n’a pas été alerté.");
		defquest1resp3.setQuestion(def1);
		defquest1resp3.setJuste(false);
		defquest1resp3 = reponseRepo.save(defquest1resp3);

		Reponse defquest2resp1 = new Reponse();
		defquest2resp1.setEnonce("Il est dédié à une tâche particulière");
		defquest2resp1.setQuestion(def2);
		defquest2resp1.setJuste(false);
		defquest2resp1 = reponseRepo.save(defquest2resp1);

		Reponse defquest2resp2 = new Reponse();
		defquest2resp2.setEnonce("Il interagit avec l’environnement extérieur par des capteurs et des actionneurs");
		defquest2resp2.setQuestion(def2);
		defquest2resp2.setJuste(true);
		defquest2resp2 = reponseRepo.save(defquest2resp2);

		Reponse defquest2resp3 = new Reponse();
		defquest2resp3.setEnonce("Il interagit en temps réel avec son environnement");
		defquest2resp3.setQuestion(def2);
		defquest2resp3.setJuste(true);
		defquest2resp3 = reponseRepo.save(defquest2resp3);

		Reponse defquest2resp4 = new Reponse();
		defquest2resp4
				.setEnonce("Il est soumis à des contraintes de fiabilité, de temps de réponse et de durée de vie");
		defquest2resp4.setQuestion(def2);
		defquest2resp4.setJuste(false);
		defquest2resp4 = reponseRepo.save(defquest2resp4);

		Reponse defquest3resp1 = new Reponse();
		defquest3resp1.setEnonce("économiques");
		defquest3resp1.setQuestion(def3);
		defquest3resp1.setJuste(true);
		defquest3resp1 = reponseRepo.save(defquest3resp1);

		Reponse defquest3resp2 = new Reponse();
		defquest3resp2.setEnonce("réglementaires");
		defquest3resp2.setQuestion(def3);
		defquest3resp2.setJuste(true);
		defquest3resp2 = reponseRepo.save(defquest3resp2);

		Reponse defquest3resp3 = new Reponse();
		defquest3resp3.setEnonce("environnementales");
		defquest3resp3.setQuestion(def3);
		defquest3resp3.setJuste(true);
		defquest3resp3 = reponseRepo.save(defquest3resp3);

		Reponse defquest3resp4 = new Reponse();
		defquest3resp4.setEnonce("culturelles");
		defquest3resp4.setQuestion(def3);
		defquest3resp4.setJuste(true);
		defquest3resp4 = reponseRepo.save(defquest3resp4);

		Reponse defquest3resp5 = new Reponse();
		defquest3resp5.setEnonce("écologiques");
		defquest3resp5.setQuestion(def3);
		defquest3resp5.setJuste(true);
		defquest3resp5 = reponseRepo.save(defquest3resp5);

		Reponse defquest4resp1 = new Reponse();
		defquest4resp1.setEnonce("avoir une vue globale");
		defquest4resp1.setQuestion(def4);
		defquest4resp1.setJuste(true);
		defquest4resp1 = reponseRepo.save(defquest4resp1);

		Reponse defquest4resp2 = new Reponse();
		defquest4resp2.setEnonce(
				"penser à tout, en considérant l’ensemble des acteurs sur l’ensemble du cycle de vie du système");
		defquest4resp2.setQuestion(def4);
		defquest4resp2.setJuste(true);
		defquest4resp2 = reponseRepo.save(defquest4resp2);

		Reponse defquest4resp3 = new Reponse();
		defquest4resp3.setEnonce("survoler la situation sans l’approfondir");
		defquest4resp3.setQuestion(def4);
		defquest4resp3.setJuste(false);
		defquest4resp3 = reponseRepo.save(defquest4resp3);

		Reponse defquest4resp4 = new Reponse();
		defquest4resp4.setEnonce("avoir une attention particulière aux éléments technologiques");
		defquest4resp4.setQuestion(def4);
		defquest4resp4.setJuste(false);
		defquest4resp4 = reponseRepo.save(defquest4resp4);

		Reponse defquest4resp5 = new Reponse();
		defquest4resp5.setEnonce("commencer à réfléchir aux fonctionnalités de haut niveau du système");
		defquest4resp5.setQuestion(def4);
		defquest4resp5.setJuste(false);
		defquest4resp5 = reponseRepo.save(defquest4resp5);

		Reponse defquest5resp1 = new Reponse();
		defquest5resp1.setEnonce("la personne qui possède l’objet connecté.");
		defquest5resp1.setQuestion(def5);
		defquest5resp1.setJuste(true);
		defquest5resp1 = reponseRepo.save(defquest5resp1);

		Reponse defquest5resp2 = new Reponse();
		defquest5resp2.setEnonce("les personnes qui fabriquent l’objet connecté.");
		defquest5resp2.setQuestion(def5);
		defquest5resp2.setJuste(true);
		defquest5resp2 = reponseRepo.save(defquest5resp2);

		Reponse defquest5resp3 = new Reponse();
		defquest5resp3.setEnonce("l’organisme qui légifère sur l’objet connecté.");
		defquest5resp3.setQuestion(def5);
		defquest5resp3.setJuste(false);
		defquest5resp3 = reponseRepo.save(defquest5resp3);

		Reponse defquest5resp4 = new Reponse();
		defquest5resp4.setEnonce("les distributeurs d’objets connectés.");
		defquest5resp4.setQuestion(def5);
		defquest5resp4.setJuste(true);
		defquest5resp4 = reponseRepo.save(defquest5resp4);

		Reponse defquest6resp1 = new Reponse();
		defquest6resp1.setEnonce("l’agent de maintenance");
		defquest6resp1.setQuestion(def6);
		defquest6resp1.setJuste(true);
		defquest6resp1 = reponseRepo.save(defquest6resp1);

		Reponse defquest6resp2 = new Reponse();
		defquest6resp2.setEnonce("le fournisseur de l’outillage");
		defquest6resp2.setQuestion(def6);
		defquest6resp2.setJuste(true);
		defquest6resp2 = reponseRepo.save(defquest6resp2);

		Reponse defquest6resp3 = new Reponse();
		defquest6resp3.setEnonce("les réseaux sociaux de blogueurs sur les détecteurs de fumée");
		defquest6resp3.setQuestion(def6);
		defquest6resp3.setJuste(false);
		defquest6resp3 = reponseRepo.save(defquest6resp3);

		Reponse defquest6resp4 = new Reponse();
		defquest6resp4.setEnonce("l’assureur du local dans lequel le détecteur sera installé");
		defquest6resp4.setQuestion(def6);
		defquest6resp4.setJuste(true);
		defquest6resp4 = reponseRepo.save(defquest6resp4);

		Reponse defquest6resp5 = new Reponse();
		defquest6resp5.setEnonce("les voisins du local");
		defquest6resp5.setQuestion(def6);
		defquest6resp5.setJuste(false);
		defquest6resp5 = reponseRepo.save(defquest6resp5);

		Reponse defquest7resp1 = new Reponse();
		defquest7resp1.setEnonce("D’un enregistreur de données de vol d’un avion.");
		defquest7resp1.setQuestion(def7);
		defquest7resp1.setJuste(true);
		defquest7resp1 = reponseRepo.save(defquest7resp1);

		Reponse defquest7resp2 = new Reponse();
		defquest7resp2.setEnonce("D’une boîte opaque.");
		defquest7resp2.setQuestion(def7);
		defquest7resp2.setJuste(false);
		defquest7resp2 = reponseRepo.save(defquest7resp2);

		Reponse defquest7resp3 = new Reponse();
		defquest7resp3.setEnonce(
				"D’un système dont le fonctionnement interne est délibérément ignoré pour se focaliser sur les interactions du système avec son environnement.");
		defquest7resp3.setQuestion(def7);
		defquest7resp3.setJuste(true);
		defquest7resp3 = reponseRepo.save(defquest7resp3);

		Reponse defquest8resp1 = new Reponse();
		defquest8resp1.setEnonce("Oui");
		defquest8resp1.setQuestion(def8);
		defquest8resp1.setJuste(true);
		defquest8resp1 = reponseRepo.save(defquest8resp1);

		Reponse defquest8resp2 = new Reponse();
		defquest8resp2.setEnonce("Non");
		defquest8resp2.setQuestion(def8);
		defquest8resp2.setJuste(false);
		defquest8resp2 = reponseRepo.save(defquest8resp2);

		Reponse defquest9resp1 = new Reponse();
		defquest9resp1.setEnonce("Conception");
		defquest9resp1.setQuestion(def9);
		defquest9resp1.setJuste(true);
		defquest9resp1 = reponseRepo.save(defquest9resp1);

		Reponse defquest9resp2 = new Reponse();
		defquest9resp2.setEnonce("Commercialisation");
		defquest9resp2.setQuestion(def9);
		defquest9resp2.setJuste(false);
		defquest9resp2 = reponseRepo.save(defquest9resp2);

		Reponse defquest9resp3 = new Reponse();
		defquest9resp3.setEnonce("Réalisation");
		defquest9resp3.setQuestion(def9);
		defquest9resp3.setJuste(true);
		defquest9resp3 = reponseRepo.save(defquest9resp3);

		Reponse defquest9resp4 = new Reponse();
		defquest9resp4.setEnonce("Qualification");
		defquest9resp4.setQuestion(def9);
		defquest9resp4.setJuste(true);
		defquest9resp4 = reponseRepo.save(defquest9resp4);

		Reponse defquest9resp5 = new Reponse();
		defquest9resp5.setEnonce("Exploitation");
		defquest9resp5.setQuestion(def9);
		defquest9resp5.setJuste(true);
		defquest9resp5 = reponseRepo.save(defquest9resp5);

		Reponse defquest9resp6 = new Reponse();
		defquest9resp6.setEnonce("Démantèlement");
		defquest9resp6.setQuestion(def9);
		defquest9resp6.setJuste(false);
		defquest9resp6 = reponseRepo.save(defquest9resp6);

		Reponse defquest9resp7 = new Reponse();
		defquest9resp7.setEnonce("Mise au point");
		defquest9resp7.setQuestion(def9);
		defquest9resp7.setJuste(false);
		defquest9resp7 = reponseRepo.save(defquest9resp7);

		Reponse defquest10resp1 = new Reponse();
		defquest10resp1.setEnonce("Connaître les besoins attendus concernant le comportement du système");
		defquest10resp1.setQuestion(def10);
		defquest10resp1.setJuste(false);
		defquest10resp1 = reponseRepo.save(defquest10resp1);

		Reponse defquest10resp2 = new Reponse();
		defquest10resp2.setEnonce("Connaître les besoins attendus concernant la performance à atteindre.");
		defquest10resp2.setQuestion(def10);
		defquest10resp2.setJuste(false);
		defquest10resp2 = reponseRepo.save(defquest10resp2);

		Reponse defquest10resp3 = new Reponse();
		defquest10resp3.setEnonce("Vérifier que le produit n'a pas de défauts résiduels");
		defquest10resp3.setQuestion(def10);
		defquest10resp3.setJuste(true);
		defquest10resp3 = reponseRepo.save(defquest10resp3);

		Reponse defquest10resp4 = new Reponse();
		defquest10resp4
				.setEnonce("Déterminer de façon détaillée les composants électroniques qui constituent le produit");
		defquest10resp4.setQuestion(def10);
		defquest10resp4.setJuste(false);
		defquest10resp4 = reponseRepo.save(defquest10resp4);

		Reponse defquest10resp5 = new Reponse();
		defquest10resp5.setEnonce("Connaître les contraintes que le système doit satisfaire");
		defquest10resp5.setQuestion(def10);
		defquest10resp5.setJuste(true);
		defquest10resp5 = reponseRepo.save(defquest10resp5);

		Reponse defquest10resp6 = new Reponse();
		defquest10resp6.setEnonce(
				"Permettre à terme de valider objectivement ce qui est développé, par rapport à ce qui est attendu");
		defquest10resp6.setQuestion(def10);
		defquest10resp6.setJuste(true);
		defquest10resp6 = reponseRepo.save(defquest10resp6);

		Reponse defquest11resp1 = new Reponse();
		defquest11resp1.setEnonce("Le coût de la solution finale");
		defquest11resp1.setQuestion(def11);
		defquest11resp1.setJuste(false);
		defquest11resp1 = reponseRepo.save(defquest11resp1);

		Reponse defquest11resp2 = new Reponse();
		defquest11resp2.setEnonce("Le temps nécessaire pour mettre en œuvre la solution sur le marché");
		defquest11resp2.setQuestion(def11);
		defquest11resp2.setJuste(true);
		defquest11resp2 = reponseRepo.save(defquest11resp2);

		Reponse defquest11resp3 = new Reponse();
		defquest11resp3.setEnonce("La capacité de la solution à être réutilisée");
		defquest11resp3.setQuestion(def11);
		defquest11resp3.setJuste(false);
		defquest11resp3 = reponseRepo.save(defquest11resp3);

		Reponse defquest11resp4 = new Reponse();
		defquest11resp4.setEnonce("Le comportement final du produit");
		defquest11resp4.setQuestion(def11);
		defquest11resp4.setJuste(true);
		defquest11resp4 = reponseRepo.save(defquest11resp4);

		Reponse defquest11resp5 = new Reponse();
		defquest11resp5.setEnonce("La performance finale du produit");
		defquest11resp5.setQuestion(def11);
		defquest11resp5.setJuste(true);
		defquest11resp5 = reponseRepo.save(defquest11resp5);

		Chapitre detect11 = new Chapitre();
		detect11.setTitre("Découvrez le domaine des systèmes embarqués et objets connectés");
		detect11.setAgencement(0);
		detect11.setModule(definition);
		detect11 = chapitreRepo.save(detect11);

		Paragraphe chap1par1 = new Paragraphe();
		chap1par1.setAgencement(0);
		chap1par1.setTexte(
				"Les systèmes embarqués nous accompagnent au quotidien et nous offrent des services qui nous facilitent la vie : smartphones, drones, robots jouets, appareils ménagers, systèmes d’aide à la conduite automobile, dispositifs de surveillance à distance du domicile et bien d’autres encore.");
		chap1par1.setChapitre(detect11);
		chap1par1 = (Paragraphe) elementDeCoursRepo.save(chap1par1);

		Paragraphe chap1par2 = new Paragraphe();
		chap1par2.setAgencement(1);
		chap1par2.setTexte(
				"Ils sont présents dans la santé, la domotique, la défense, le contrôle de processus industriel, les transports, les infrastructures critiques comme le nucléaire ou l’énergie, les loisirs ou encore l’agriculture…. Ils sont pour la plupart fortement connectés.");
		chap1par2.setChapitre(detect11);
		chap1par2 = (Paragraphe) elementDeCoursRepo.save(chap1par2);

		Paragraphe chap1par3 = new Paragraphe();
		chap1par3.setAgencement(2);
		chap1par3.setTexte(
				"La disponibilité croissante de la technologie fait exploser à la fois l'offre et la demande. Le domaine des systèmes embarqués constitue un secteur d’activité dynamique, fondamentalement pluri- et interdisciplinaire, dans lequel des perspectives nouvelles d’application émergent chaque jour.");
		chap1par3.setChapitre(detect11);
		chap1par3 = (Paragraphe) elementDeCoursRepo.save(chap1par3);

		Paragraphe chap1par4 = new Paragraphe();
		chap1par4.setAgencement(3);
		chap1par4.setTitre("Mais d’abord, qu’est-ce qu’un système embarqué ?");
		chap1par4.setTexte(
				"Les systèmes embarqués sont utilisés dans plusieurs domaines comme l'astronautique, l'aéronautique, l'automobile, l'industrie, l'informatique, l'électroménager, le militaire...");
		chap1par4.setChapitre(detect11);
		chap1par4 = (Paragraphe) elementDeCoursRepo.save(chap1par4);

		Paragraphe chap1par5 = new Paragraphe();
		chap1par5.setAgencement(4);
		chap1par5.setTexte(
				"Un système embarqué (SE) est un système autonome, généralement fortement connecté. Il est spécialisé dans une tâche bien précise, fonctionne très souvent en temps réel, et mêle des éléments matériels et logiciels. On le qualifie d’ « embarqué » (on parle aussi de système « enfoui») car il est intégré au dispositif physique dont il assure le contrôle ou la commande, et dont il partage les contraintes d'environnement.");
		chap1par5.setChapitre(detect11);
		chap1par5 = (Paragraphe) elementDeCoursRepo.save(chap1par5);

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

		Cours javaDebutant = new Cours();
		javaDebutant.setIntitule("Apprenez les bases de java");
		javaDebutant.setDifficulte(Difficulte.FACILE);
		javaDebutant.setDuree(5);
		javaDebutant.setEtat(Etat.OUVERT);
		javaDebutant.setDescription(
				"Dans ce cours, vous allez apprendre les bases du langage de programmation le plus utilisé au monde");
		javaDebutant.setCheminImageCours("Le chemin");
		javaDebutant.setEntreprise(sopra);
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

	}

}
