package projet.holyweb.services;

import java.io.IOException;
import java.util.List;

import projet.holyweb.entities.Employe;
import projet.holyweb.managers.EmployeDAO;

public class EmployeService {
	
	//Lien servlet-DAO

private EmployeDAO EmployeDAO = new EmployeDAO();
	
	private static class EmployeServiceHolder{
		private static EmployeService instance = new EmployeService();
	}
	
	public static EmployeService getInstance(){
		return EmployeServiceHolder.instance;
	}
	private EmployeService(){}
	
	public List<Employe> ListEmploye(){
		return EmployeDAO.listEmploye();
	}
	
	public Employe getEmploye(String idEmploye){
		return EmployeDAO.getEmploye(idEmploye);
	}
	
	public void updateEmploye(String idEmploye, String mdpEmploye, String dateNaissanceEmploye, String nomEmploye, String prenomEmploye, String telephoneEmploye, String mailEmploye, Boolean interimaire, Integer idCategorie, Integer idConge) throws IOException{
		EmployeDAO.updateEmploye(idEmploye, mdpEmploye, dateNaissanceEmploye, nomEmploye, prenomEmploye, telephoneEmploye, mailEmploye, interimaire, idCategorie, idConge);
	}
	
	public void addEmploye(Employe nouvelEmploye){
		EmployeDAO.addEmploye(nouvelEmploye);
	}
	
	public void deleteEmploye(Integer idEmploye){
		EmployeDAO.deleteEmploye(idEmploye);
	}
}
