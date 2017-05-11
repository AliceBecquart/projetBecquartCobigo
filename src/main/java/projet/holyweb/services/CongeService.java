package projet.holyweb.services;

import java.io.IOException;
import java.util.List;

import projet.holyweb.entities.Conge;
import projet.holyweb.managers.CongeDAO;

public class CongeService {
	
	//Lien servlet-DAO

private CongeDAO CongeDAO = new CongeDAO();
	
	private static class CongeServiceHolder{
		private static CongeService instance = new CongeService();
	}
	
	public static CongeService getInstance(){
		return CongeServiceHolder.instance;
	}
	private CongeService(){}
	
	public List<Conge> Conge(){
		return CongeDAO.Conge();
	}
	
	public List<Conge> ListeConge(){
		return CongeDAO.listeConge();
	}
	
	public Conge getConge(Integer idConge){
		return CongeDAO.getConge(idConge);
	}
	
	public void updateConge(Integer idConge, String dateDebutConge, String dateFinConge, Boolean matin, Boolean apresMidi, String numeroSemaineConge, String dateDemandeConge, Boolean demandeValide, String dateValidation, Integer idTypeConge) throws IOException{
		CongeDAO.updateConge(idConge, dateDebutConge, dateFinConge, matin, apresMidi, numeroSemaineConge, dateDemandeConge, demandeValide, dateValidation, idTypeConge);
	}
	
	public void addConge(Conge nouveauConge){
		CongeDAO.addConge(nouveauConge);
	}
	
	public void deleteConge(Integer idConge){
		CongeDAO.deleteConge(idConge);
	}
	
	public void validerConge(Integer idConge){
		CongeDAO.validerConge(idConge);
	}
	
}
