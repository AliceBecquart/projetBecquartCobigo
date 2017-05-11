package projet.holyweb.services;

import java.io.IOException;
import java.util.List;

import projet.holyweb.entities.TypeConge;
import projet.holyweb.managers.TypeCongeDAO;

public class TypeCongeService {
	
	//Lien servlet-DAO

private TypeCongeDAO TypeCongeDAO = new TypeCongeDAO();
	
	private static class TypeCongeServiceHolder{
		private static TypeCongeService instance = new TypeCongeService();
	}
	
	public static TypeCongeService getInstance(){
		return TypeCongeServiceHolder.instance;
	}
	private TypeCongeService(){}
	
	public List<TypeConge> TypeConge(){
		return TypeCongeDAO.TypeConge();
	}
	
	public TypeConge getTypeConge(Integer idTypeConge){
		return TypeCongeDAO.getTypeConge(idTypeConge);
	}
	
	public void updateTypeConge(Integer idTypeConge, String libelleTypeConge) throws IOException{
		TypeCongeDAO.updateTypeConge(idTypeConge, libelleTypeConge);
	}
	
	public void addTypeConge(TypeConge nouveauTypeConge){
		TypeCongeDAO.addTypeConge(nouveauTypeConge);
	}
	
	public void deleteTypeConge(Integer idTypeConge){
		TypeCongeDAO.deleteTypeConge(idTypeConge);
	}
}
