package projet.holyweb.services;

import java.io.IOException;
import java.util.List;

import projet.holyweb.entities.Disponibilite;
import projet.holyweb.managers.DisponibiliteDAO;

public class DisponibiliteService {
	
	//Lien servlet-DAO

private DisponibiliteDAO DisponibiliteDAO = new DisponibiliteDAO();
	
	private static class DisponibiliteServiceHolder{
		private static DisponibiliteService instance = new DisponibiliteService();
	}
	
	public static DisponibiliteService getInstance(){
		return DisponibiliteServiceHolder.instance;
	}
	private DisponibiliteService(){}
	
	public List<Disponibilite> listDisponibilite(){
		return DisponibiliteDAO.listDisponibilite();
	}
	
	public List<Disponibilite> listDisponibiliteNA(){
		return DisponibiliteDAO.listDisponibiliteNA();
	}
	
	public Disponibilite getDisponibilite(Integer idDispo){
		return DisponibiliteDAO.getDisponibilite(idDispo);
	}
	
	public void updateDisponibilite(Integer idDispo, String dateDebutDispo, String dateFinDispo, Boolean matin, Boolean apresMidi, Boolean affecte, Integer idEmploye) throws IOException{
		DisponibiliteDAO.updateDisponibilite(idDispo, dateDebutDispo, dateFinDispo, matin, apresMidi, affecte, idEmploye);	
		}
	
	public void addDisponibilite(Disponibilite nouvelleDisponibilite){
		DisponibiliteDAO.addDisponibilite(nouvelleDisponibilite);
	}
	
	public void deleteDisponibilite(Integer idDispo){
		DisponibiliteDAO.deleteDisponibilite(idDispo);
	}
}
