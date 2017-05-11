package projet.holyweb.entities;

public class Remplacement {
	
	//Définition d'un remplacement
	private Integer idRemplacement;
	private Integer idEmployeRemplacant;
	private Integer idEmployeRemplace;
	private Integer idDispo;

	public Remplacement(Integer idRemplacement, Integer idEmployeRemplacant,
			Integer idEmployeRemplace, Integer idDispo){
		
		super();
		this.idRemplacement = idRemplacement;
		this.idEmployeRemplacant = idEmployeRemplacant;
		this.idEmployeRemplace = idEmployeRemplace;
		this.idDispo = idDispo;
	}

	//Getters and Setters
	public Integer getIdRemplacement() {
		return idRemplacement;
	}

	public void setIdRemplacement(Integer idRemplacement) {
		this.idRemplacement = idRemplacement;
	}

	public Integer getIdEmployeRemplacant() {
		return idEmployeRemplacant;
	}

	public void setIdEmployeRemplacant(Integer idEmployeRemplacant) {
		this.idEmployeRemplacant = idEmployeRemplacant;
	}

	public Integer getIdEmployeRemplace() {
		return idEmployeRemplace;
	}

	public void setIdEmployeRemplace(Integer idEmployeRemplace) {
		this.idEmployeRemplace = idEmployeRemplace;
	}

	public Integer getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(Integer idDispo) {
		this.idDispo = idDispo;
	}
	
	
}
