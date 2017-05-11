package projet.holyweb.entities;

public class Categorie {

	// Définition d'une catégorie
	private Integer idCategorie;
	private String libelleCategorie;
	
	public Categorie (Integer idCategorie, String libelleCategorie){
		super();
		this.idCategorie = idCategorie;
		this.libelleCategorie = libelleCategorie;				
	}

	//Getters and Setters
	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public String getLibelleCategorie() {
		return libelleCategorie;
	}

	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}
	
	
}

