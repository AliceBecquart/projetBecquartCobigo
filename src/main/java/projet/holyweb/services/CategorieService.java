package projet.holyweb.services;

import projet.holyweb.managers.CategorieDAO;
import projet.holyweb.entities.Categorie;
import java.io.IOException;
import java.util.List;

public class CategorieService {
	
	//Lien servlet-DAO

	private CategorieDAO CategorieDAO = new CategorieDAO();
	
	private static class CategorieServiceHolder{
		private static CategorieService instance = new CategorieService();
	}
	
	public static CategorieService getInstance(){
		return CategorieServiceHolder.instance;
	}
	private CategorieService(){}
	
	public List<Categorie> ListCategorie(){
		return CategorieDAO.listCategorie();
	}
	
	public Categorie getCategorie(Integer idCategorie){
		return CategorieDAO.getCategorie(idCategorie);
	}
	
	public void updateCategorie(Integer idCategorie, String libelleCategorie) throws IOException{
		CategorieDAO.updateCategorie(idCategorie, libelleCategorie);
	}
	
	public void addCategorie(Categorie nouvelleCategorie){
		CategorieDAO.addCategorie(nouvelleCategorie);
	}
	
	public void deleteCategorie(Integer idCategorie){
		CategorieDAO.deleteCategorie(idCategorie);
	}
}

	
