package sopra.skeelz;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import sopra.skeelz.model.BilanCompetence;
import sopra.skeelz.model.Chapitre;
import sopra.skeelz.model.Competence;
import sopra.skeelz.model.CompetenceSkeelz;
import sopra.skeelz.model.Cours;
import sopra.skeelz.model.CoursCompetence;
import sopra.skeelz.model.CoursPersonne;
import sopra.skeelz.model.Difficulte;
import sopra.skeelz.model.ElementDeCours;
import sopra.skeelz.model.Entreprise;
import sopra.skeelz.model.Etat;
import sopra.skeelz.model.EtatCours;
import sopra.skeelz.model.ExtraitCode;
import sopra.skeelz.model.ImageCours;
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

@SpringBootTest
class ModeleTest {

	@Test
	void BilanCompetence() {

		BilanCompetence bilanCompetence = new BilanCompetence();
		bilanCompetence.setId(0l);
		bilanCompetence.setVersion(0);
		bilanCompetence.setCompetenceSkeelz(null);
		bilanCompetence.setPersonne(null);

		assertEquals(0l, bilanCompetence.getId());
		assertEquals(0, bilanCompetence.getVersion());
		assertEquals(null, bilanCompetence.getCompetenceSkeelz());
		assertEquals(null, bilanCompetence.getPersonne());
	}

	@Test
	void Chapitre() {

		Chapitre chapitre = new Chapitre();
		chapitre.setId(0l);
		chapitre.setVersion(0);
		chapitre.setAgencement(0);
		chapitre.setTitre("aaa");
		chapitre.setModule(null);
		chapitre.setElementsDeCours(null);

		assertEquals(0l, chapitre.getId());
		assertEquals(0, chapitre.getVersion());
		assertEquals(0, chapitre.getAgencement());
		assertEquals("aaa", chapitre.getTitre());
		assertEquals(null, chapitre.getModule());
		assertEquals(null, chapitre.getElementsDeCours());
	}

	@Test
	void Competence() {

		Competence competence = new Competence();
		competence.setId(0l);
		competence.setVersion(0);
		competence.setIntitule("aaa");
		competence.setDescription("aaa");
		competence.setPonderation(Ponderation.CINQ);
		competence.setCompetenceSkeelz(null);
		competence.setCoursCompetence(null);
		competence.setEntreprise(null);

		assertEquals(0l, competence.getId());
		assertEquals(0, competence.getVersion());
		assertEquals("aaa", competence.getIntitule());
		assertEquals("aaa", competence.getDescription());
		assertEquals(5, competence.getPonderation().getLabel());
		assertEquals(null, competence.getCompetenceSkeelz());
		assertEquals(null, competence.getCoursCompetence());
		assertEquals(null, competence.getEntreprise());
	}

	@Test
	void CompetenceSkeelz() {

		CompetenceSkeelz competenceSkeelz = new CompetenceSkeelz();
		competenceSkeelz.setId(0l);
		competenceSkeelz.setVersion(0);
		competenceSkeelz.setSkeelz(null);
		competenceSkeelz.setBilanCompetence(null);
		competenceSkeelz.setCompetence(null);

		assertEquals(0l, competenceSkeelz.getId());
		assertEquals(0, competenceSkeelz.getVersion());
		assertEquals(null, competenceSkeelz.getSkeelz());
		assertEquals(null, competenceSkeelz.getCompetence());
		assertEquals(null, competenceSkeelz.getBilanCompetence());
	}

	@Test
	void Cours() {

		Cours cours = new Cours();
		cours.setId(0l);
		cours.setVersion(0);
		cours.setCheminImageCours("aaa");
		cours.setCoursCompetences(null);
		cours.setCoursPersonnes(null);
		cours.setDescription("aaa");
		cours.setDifficulte(Difficulte.FACILE);
		cours.setDuree(5);
		cours.setEntreprise(null);
		cours.setEtat(Etat.ATTENTE);
		cours.setIntitule("aaa");
		cours.setModules(null);

		assertEquals(0l, cours.getId());
		assertEquals(0, cours.getVersion());
		assertEquals("aaa", cours.getCheminImageCours());
		assertEquals(null, cours.getCoursCompetences());
		assertEquals(null, cours.getCoursPersonnes());
		assertEquals("aaa", cours.getDescription());
		assertEquals("Facile", cours.getDifficulte().getLabel());
		assertEquals(5, cours.getDuree());
		assertEquals(null, cours.getEntreprise());
		assertEquals("En attende de validation", cours.getEtat().getLabel());
		assertEquals("aaa", cours.getIntitule());
		assertEquals(null, cours.getModules());
	}

	@Test
	void CoursCompetence() {

		CoursCompetence coursCompetence = new CoursCompetence();
		coursCompetence.setId(0l);
		coursCompetence.setVersion(0);
		coursCompetence.setCompetence(null);
		coursCompetence.setCours(null);
		coursCompetence.setRelationCours(RelationCours.REQUIERE);

		assertEquals(0l, coursCompetence.getId());
		assertEquals(0, coursCompetence.getVersion());
		assertEquals(null, coursCompetence.getCompetence());
		assertEquals(null, coursCompetence.getCours());
		assertEquals("Compétence requise", coursCompetence.getRelationCours().getLabel());

	}

	@Test
	void CoursPersonne() {

		CoursPersonne coursPersonne = new CoursPersonne();
		coursPersonne.setId(0l);
		coursPersonne.setVersion(0);
		coursPersonne.setCours(null);
		coursPersonne.setPersonne(null);
		coursPersonne.setEtatCours(EtatCours.ADMINISTRE);

		assertEquals(0l, coursPersonne.getId());
		assertEquals(0, coursPersonne.getVersion());
		assertEquals(null, coursPersonne.getCours());
		assertEquals(null, coursPersonne.getPersonne());
		assertEquals("administre", coursPersonne.getEtatCours().getLabel());

	}

	@Test
	void ElementDeCours() {

		ElementDeCours elementDeCours = new Paragraphe();
		elementDeCours.setId(0l);
		elementDeCours.setVersion(0);
		elementDeCours.setAgencement(0);
		elementDeCours.setChapitre(null);

		assertEquals(0l, elementDeCours.getId());
		assertEquals(0, elementDeCours.getVersion());
		assertEquals(0, elementDeCours.getAgencement());
		assertEquals(null, elementDeCours.getChapitre());

	}

	@Test
	void Entreprise() {

		Entreprise entreprise = new Entreprise();
		entreprise.setId(0l);
		entreprise.setVersion(0);
		entreprise.setAdministrateur(null);
		entreprise.setCompetences(null);
		entreprise.setCourss(null);
		entreprise.setNom("aaa");
		entreprise.setNumeroSiret("aaa");
		entreprise.setSkeelzs(null);
		entreprise.setTypeContrat("aaa");

		assertEquals(0l, entreprise.getId());
		assertEquals(0, entreprise.getVersion());
		assertEquals(null, entreprise.getAdministrateur());
		assertEquals(null, entreprise.getCompetences());
		assertEquals(null, entreprise.getCourss());
		assertEquals("aaa", entreprise.getNom());
		assertEquals("aaa", entreprise.getNumeroSiret());
		assertEquals(null, entreprise.getSkeelzs());
		assertEquals("aaa", entreprise.getTypeContrat());

	}

	@Test
	void ExtraitCode() {

		ExtraitCode extraitCode = new ExtraitCode();
		extraitCode.setId(0l);
		extraitCode.setVersion(0);
		extraitCode.setAgencement(0);
		extraitCode.setChapitre(null);
		extraitCode.setCommentaire("aaa");
		extraitCode.setContenu("aaa");

		assertEquals(0l, extraitCode.getId());
		assertEquals(0, extraitCode.getVersion());
		assertEquals(0, extraitCode.getAgencement());
		assertEquals(null, extraitCode.getChapitre());
		assertEquals("aaa", extraitCode.getCommentaire());
		assertEquals("aaa", extraitCode.getContenu());

	}

	@Test
	void ImageCours() {

		ImageCours imageCours = new ImageCours();
		imageCours.setId(0l);
		imageCours.setVersion(0);
		imageCours.setAgencement(0);
		imageCours.setChapitre(null);
		imageCours.setCommentaire("aaa");
		imageCours.setChemin("aaa");

		assertEquals(0l, imageCours.getId());
		assertEquals(0, imageCours.getVersion());
		assertEquals(0, imageCours.getAgencement());
		assertEquals(null, imageCours.getChapitre());
		assertEquals("aaa", imageCours.getCommentaire());
		assertEquals("aaa", imageCours.getChemin());

	}

	@Test
	void Module() {

		Module module = new Module();
		module.setId(0l);
		module.setVersion(0);
		module.setAgencement(0);
		module.setChapitres(null);
		module.setCours(null);
		module.setEnonceQCM("aaa");
		module.setIntitule("aaa");
		module.setNbQuestion(3);
		module.setNbTentativeAutorise(4);
		module.setPeriodicite(9);
		module.setQcmPersonnes(null);
		module.setQuestions(null);

		assertEquals(0l, module.getId());
		assertEquals(0, module.getVersion());
		assertEquals(0, module.getAgencement());
		assertEquals(null, module.getChapitres());
		assertEquals(null, module.getCours());
		assertEquals("aaa", module.getEnonceQCM());
		assertEquals("aaa", module.getIntitule());
		assertEquals(3, module.getNbQuestion());
		assertEquals(4, module.getNbTentativeAutorise());
		assertEquals(9, module.getPeriodicite());
		assertEquals(null, module.getQcmPersonnes());
		assertEquals(null, module.getQuestions());

	}

	@Test
	void Paragraphe() {

		Paragraphe paragraphe = new Paragraphe();
		paragraphe.setId(0l);
		paragraphe.setVersion(0);
		paragraphe.setAgencement(0);
		paragraphe.setChapitre(null);
		paragraphe.setTexte("aaa");
		paragraphe.setTitre("aaa");

		assertEquals(0l, paragraphe.getId());
		assertEquals(0, paragraphe.getVersion());
		assertEquals(0, paragraphe.getAgencement());
		assertEquals(null, paragraphe.getChapitre());
		assertEquals("aaa", paragraphe.getTexte());
		assertEquals("aaa", paragraphe.getTitre());

	}

	@Test
	void Personne() {

		Personne personne = new Personne();
		personne.setId(0l);
		personne.setVersion(0);
		personne.setBilanCompetence(null);
		personne.setCoursPersonne(null);
		personne.setNom("aaa");
		personne.setNoteGlobal(6);
		personne.setPrenom("aaa");
		personne.setQcmPersonne(null);
		personne.setTelephone("aaa");
		personne.setUtilisateur(null);

		assertEquals(0l, personne.getId());
		assertEquals(0, personne.getVersion());
		assertEquals(null, personne.getBilanCompetence());
		assertEquals(null, personne.getCoursPersonne());
		assertEquals("aaa", personne.getNom());
		assertEquals(6, personne.getNoteGlobal());
		assertEquals("aaa", personne.getPrenom());
		assertEquals(null, personne.getQcmPersonne());
		assertEquals("aaa", personne.getTelephone());
		assertEquals(null, personne.getUtilisateur());

	}

	@Test
	void QCMPersonne() {

		QCMPersonne qcmPersonne = new QCMPersonne();
		qcmPersonne.setId(0l);
		qcmPersonne.setVersion(0);
		qcmPersonne.setDateDerniereTentative(null);
		qcmPersonne.setModule(null);
		qcmPersonne.setNbTentative(6);
		qcmPersonne.setPersonne(null);
		qcmPersonne.setStatutQCM(true);

		assertEquals(0l, qcmPersonne.getId());
		assertEquals(0, qcmPersonne.getVersion());
		assertEquals(null, qcmPersonne.getDateDerniereTentative());
		assertEquals(null, qcmPersonne.getModule());
		assertEquals(6, qcmPersonne.getNbTentative());
		assertEquals(null, qcmPersonne.getPersonne());
		assertEquals(true, qcmPersonne.isStatutQCM());

	}

	@Test
	void Question() {

		Question question = new Question();
		question.setId(0l);
		question.setVersion(0);
		question.setQuestion("aaa");
		question.setModule(null);
		question.setReponses(null);

		assertEquals(0l, question.getId());
		assertEquals(0, question.getVersion());
		assertEquals("aaa", question.getQuestion());
		assertEquals(null, question.getModule());
		assertEquals(null, question.getReponses());

	}

	@Test
	void Reponse() {

		Reponse reponse = new Reponse();
		reponse.setId(0l);
		reponse.setVersion(0);
		reponse.setEnonce("aaa");
		reponse.setJuste(true);
		reponse.setQuestion(null);

		assertEquals(0l, reponse.getId());
		assertEquals(0, reponse.getVersion());
		assertEquals(null, reponse.getQuestion());
		assertEquals(true, reponse.isJuste());
		assertEquals("aaa", reponse.getEnonce());

	}

	@Test
	void Skeelz() {

		Skeelz skeelz = new Skeelz();
		skeelz.setId(0l);
		skeelz.setVersion(0);
		skeelz.setCompetenceSkeelz(null);
		skeelz.setEntreprise(null);
		skeelz.setIntitule("aaa");

		assertEquals(0l, skeelz.getId());
		assertEquals(0, skeelz.getVersion());
		assertEquals(null, skeelz.getCompetenceSkeelz());
		assertEquals(null, skeelz.getEntreprise());
		assertEquals("aaa", skeelz.getIntitule());

	}

	@Test
	void Utilisateur() {

		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setId(0l);
		utilisateur.setVersion(0);
		utilisateur.setAdministrateur(true);
		utilisateur.setEntreprise(null);
		utilisateur.setIdentifiant("aaa");
		utilisateur.setMail("aaa");
		utilisateur.setPassword("aaa");
		utilisateur.setPersonne(null);
		utilisateur.setRh(true);
		utilisateur.setSuperUser(true);

		assertEquals(0l, utilisateur.getId());
		assertEquals(0, utilisateur.getVersion());
		assertEquals(true, utilisateur.isAdministrateur());
		assertEquals(null, utilisateur.getEntreprise());
		assertEquals("aaa", utilisateur.getIdentifiant());
		assertEquals("aaa", utilisateur.getMail());
		assertEquals("aaa", utilisateur.getPassword());
		assertEquals(null, utilisateur.getPersonne());
		assertEquals(true, utilisateur.isRh());
		assertEquals(true, utilisateur.isSuperUser());

	}

}
