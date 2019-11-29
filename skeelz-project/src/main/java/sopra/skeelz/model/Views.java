package sopra.skeelz.model;

public class Views {

	public static class ViewCommon {}

	public static class ViewBilanCompetence extends ViewCommon {}

	public static class ViewSkeelz extends ViewCommon {}
	
	public static class ViewSkeelzPersonnes extends ViewSkeelz {}
	
	public static class ViewSkeelzCours extends ViewSkeelz {}

	public static class ViewCompetence extends ViewCommon {}
	
	public static class ViewCoursCompetence extends ViewCommon {}
	
	public static class ViewCompetenceSkeelz extends ViewCommon {}

	public static class ViewCours extends ViewCommon {}
	
	public static class ViewCoursModuleByAgencement extends ViewCours {}
	
	public static class ViewPersonne extends ViewCommon {}
	
	public static class ViewPersonneCourss extends ViewPersonne {}
	
	public static class ViewPersonneCompetences extends ViewPersonne {}

	public static class ViewCoursDetail extends ViewCours {}

	public static class ViewCoursPersonne extends ViewCommon {}

	public static class ViewModule extends ViewCommon {}
	
	public static class ViewCoursPersonneDetail extends ViewCoursPersonne {
	}
	public static class ViewChapitre extends ViewCommon {}
	
	public static class ViewElementdeCours extends ViewCommon {}
	
	public static class ViewQCMPersonne extends ViewCommon {}
	
	public static class ViewQCMPersonnePersonneModule extends ViewQCMPersonne {}
	
	public static class ViewQuestion extends ViewCommon {}
	
	public static class ViewReponse extends ViewCommon {}
	
	public static class ViewUtilisateur extends ViewCommon {}
	
	public static class ViewEntreprise extends ViewCommon {}
	
	public static class ViewEntrepriseUtilisateurs extends ViewEntreprise{}
	
	public static class ViewEntrepriseCourss extends ViewEntreprise{}
	
	public static class ViewEntrepriseCompetences extends ViewEntreprise{}
	
	public static class ViewEntrepriseSkeelzs extends ViewEntreprise{}
	
	public static class ViewCompetencePersonne extends ViewCommon{}
	
}

