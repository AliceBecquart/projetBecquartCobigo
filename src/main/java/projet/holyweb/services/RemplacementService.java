package projet.holyweb.services;

import java.io.IOException;
import java.util.List;

import projet.holyweb.entities.Remplacement;
import projet.holyweb.managers.RemplacementDAO;

public class RemplacementService {
	
	//Lien servlet-DAO

private RemplacementDAO RemplacementDAO = new RemplacementDAO();
	
	private static class RemplacementServiceHolder{
		private static RemplacementService instance = new RemplacementService();
	}
	
	public static RemplacementService getInstance(){
		return RemplacementServiceHolder.instance;
	}
	private RemplacementService(){}
	
	public List<Remplacement> ListRemplacement(){
		return RemplacementDAO.listRemplacement();
	}
	
	public Remplacement getRemplacement(Integer idRemplacement){
		return RemplacementDAO.getRemplacement(idRemplacement);
	}
	
	public void updateRemplacement(Integer idRemplacement, Integer idEmployeRemplacant, Integer idEmployeRemplace, Integer idDispo) throws IOException{
		RemplacementDAO.updateRemplacement(idRemplacement, idEmployeRemplacant, idEmployeRemplace, idDispo);
	}
	
	public void addRemplacement(Remplacement nouveauRemplacement){
		RemplacementDAO.addRemplacement(nouveauRemplacement);
	}
	
	public void deleteRemplacement(Integer idRemplacement){
		RemplacementDAO.deleteRemplacement(idRemplacement);
	}
}
