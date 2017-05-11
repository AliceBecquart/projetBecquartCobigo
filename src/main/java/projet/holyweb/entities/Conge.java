package projet.holyweb.entities;


public class Conge {
	
	//Définition d'un congé
	private Integer idConge;
	private String dateDebutConge;
	private String dateFinConge;
	private Boolean matin;
	private Boolean apresMidi;
	private String numeroSemaineConge;
	private String dateDemandeConge;
	private Boolean demandeValide;
	private String dateValidation;
	private Integer idTypeConge;
	
	public Conge(Integer idConge, String dateDebutConge, String dateFinConge,
			Boolean matin, Boolean apresMidi, String numeroSemaineConge,
			String dateDemandeConge, Boolean demandeValide, String dateValidation,
			Integer idTypeConge){
	
		super();
		this.idConge = idConge;
		this.dateDebutConge = dateDebutConge;
		this.dateFinConge = dateFinConge;
		this.matin = matin;
		this.apresMidi = apresMidi;
		this.numeroSemaineConge = numeroSemaineConge;
		this.dateDemandeConge = dateDemandeConge;
		this.demandeValide = demandeValide;
		this.dateValidation = dateValidation;
		this.idTypeConge = idTypeConge;
	}

	//Getters and Setters
	public Integer getIdConge() {
		return idConge;
	}

	public void setIdConge(Integer idConge) {
		this.idConge = idConge;
	}

	public String getDateDebutConge() {
		return dateDebutConge;
	}

	public void setDateDebutConge(String dateDebutConge) {
		this.dateDebutConge = dateDebutConge;
	}

	public String getDateFinConge() {
		return dateFinConge;
	}

	public void setDateFinConge(String dateFinConge) {
		this.dateFinConge = dateFinConge;
	}

	public Boolean getMatin() {
		return matin;
	}

	public void setMatin(Boolean matin) {
		this.matin = matin;
	}

	public Boolean getApresMidi() {
		return apresMidi;
	}

	public void setApresMidi(Boolean apresMidi) {
		this.apresMidi = apresMidi;
	}

	public String getNumeroSemaineConge() {
		return numeroSemaineConge;
	}

	public void setNumeroSemaineConge(String numeroSemaineConge) {
		this.numeroSemaineConge = numeroSemaineConge;
	}

	public String getDateDemandeConge() {
		return dateDemandeConge;
	}

	public void setDateDemandeConge(String dateDemandeConge) {
		this.dateDemandeConge = dateDemandeConge;
	}

	public Boolean getDemandeValide(){
		return demandeValide;
	}

	public void setEtatDemandeConge(Boolean demandeValide) {
		this.demandeValide = demandeValide;
	}

	public String getDateValidation() {
		return dateValidation;
	}

	public void setDateValidation(String dateValidation) {
		this.dateValidation = dateValidation;
	}

	public Integer getIdTypeConge() {
		return idTypeConge;
	}

	public void setIdTypeConge(Integer idTypeConge) {
		this.idTypeConge = idTypeConge;
	}
	
	
}