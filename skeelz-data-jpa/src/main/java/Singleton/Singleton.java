package Singleton;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
import repository.jpa.BilanCompetenceRepositoryJpa;
import repository.jpa.ChapitreRepositoryJpa;
import repository.jpa.CompetenceRepositoryJpa;
import repository.jpa.CompetenceSkeelzRepositoryJpa;
import repository.jpa.CoursCompetenceRepositoryJpa;
import repository.jpa.CoursPersonneRepositoryJpa;
import repository.jpa.CoursRepositoryJpa;
import repository.jpa.ElementDeCoursRepositoryJpa;
import repository.jpa.EntrepriseRepositoryJpa;
import repository.jpa.ModuleRepositoryJpa;
import repository.jpa.PersonneRepositoryJpa;
import repository.jpa.QCMPersonneRepositoryJpa;
import repository.jpa.QuestionRepositoryJpa;
import repository.jpa.ReponseRepositoryJpa;
import repository.jpa.SkeelzRepositoryJpa;
import repository.jpa.UtilisateurRepositoryJpa;


public class Singleton {
	
	private static Singleton instance = null;
	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("skeelz-tp");
	
	private final IBilanCompetenceRepository bilanCompetenceRepo = new BilanCompetenceRepositoryJpa();
	private final IChapitreRepository chapitreRepo = new ChapitreRepositoryJpa();
	private final ICompetenceRepository competenceRepo = new CompetenceRepositoryJpa();
	private final ICoursCompetenceRepository coursCompetenceRepo = new CoursCompetenceRepositoryJpa();
	private final ICoursPersonneRepository coursPersonneRepo = new CoursPersonneRepositoryJpa();
	private final ICoursRepository coursRepo = new CoursRepositoryJpa();
	private final IElementDeCoursRepository elementDeCoursRepo = new ElementDeCoursRepositoryJpa();
	private final IEntrepriseRepository entrepriseRepo = new EntrepriseRepositoryJpa();
	private final IModuleRepository moduleRepo = new ModuleRepositoryJpa();
	private final IPersonneRepository personneRepo = new PersonneRepositoryJpa();
	private final IQCMPersonneRepository qcmPersonneRepo = new QCMPersonneRepositoryJpa();
	private final IQuestionRepository questionRepo = new QuestionRepositoryJpa();
	private final IReponseRepository reponseRepo = new ReponseRepositoryJpa();
	private final ISkeelzRepository skeelzRepo = new SkeelzRepositoryJpa();
	private final IUtilisateurRepository utilisateurRepo = new UtilisateurRepositoryJpa();
	private final ICompetenceSkeelzRepository competenceSkeelzRepo = new CompetenceSkeelzRepositoryJpa();

	
	private Singleton() {
	}

	public static Singleton getInstance() {
		if (instance == null) {
			instance = new Singleton();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public IBilanCompetenceRepository getBilanCompetenceRepo() {
		return bilanCompetenceRepo;
	}

	public IChapitreRepository getChapitreRepo() {
		return chapitreRepo;
	}

	public ICompetenceRepository getCompetenceRepo() {
		return competenceRepo;
	}

	public ICoursCompetenceRepository getCoursCompetenceRepo() {
		return coursCompetenceRepo;
	}

	public ICoursPersonneRepository getCoursPersonneRepo() {
		return coursPersonneRepo;
	}

	public ICoursRepository getCoursRepo() {
		return coursRepo;
	}

	

	public IEntrepriseRepository getEntrepriseRepo() {
		return entrepriseRepo;
	}

	public IModuleRepository getModuleRepo() {
		return moduleRepo;
	}

	public IPersonneRepository getPersonneRepo() {
		return personneRepo;
	}

	public IQCMPersonneRepository getQcmPersonneRepo() {
		return qcmPersonneRepo;
	}

	public IQuestionRepository getQuestionRepo() {
		return questionRepo;
	}

	public IReponseRepository getReponseRepo() {
		return reponseRepo;
	}

	public ISkeelzRepository getSkeelzRepo() {
		return skeelzRepo;
	}

	public IUtilisateurRepository getUtilisateurRepo() {
		return utilisateurRepo;
	}

	
	public ICompetenceSkeelzRepository getCompetenceSkeelzRepo() {
		return competenceSkeelzRepo;
	}

	/**
	 * @return the elementDeCoursRepo
	 */
	public IElementDeCoursRepository getElementDeCoursRepo() {
		return elementDeCoursRepo;
	}
	
	

	
	
}
