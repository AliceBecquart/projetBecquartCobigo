package projet.holyweb.entities;

public class TypeConge {

	//Définition d'un type de congé
	private Integer idTypeConge;
	private String libelleTypeConge;
	
	public TypeConge (Integer idTypeConge, String libelleTypeConge){
	
		super();
		this.idTypeConge = idTypeConge;
		this.libelleTypeConge = libelleTypeConge;
	}
	
	//Getters and Setters
	public Integer getIdTypeConge() {
		return idTypeConge;
	}

	public void setIdTypeConge(Integer idTypeConge) {
		this.idTypeConge = idTypeConge;
	}

	public String getLibelleTypeConge() {
		return libelleTypeConge;
	}

	public void setLibelleTypeConge(String libelleTypeConge) {
		this.libelleTypeConge = libelleTypeConge;
	}
	
}

