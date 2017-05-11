package projet.holyweb.entities;


public class Disponibilite {

	//Définition d'une disponibilité
	private Integer idDispo;
	private String dateDebutDispo;
	private String dateFinDispo;
	private Boolean matin;
	private Boolean apresMidi;
	private Boolean affecte;
	private Integer idEmploye;
	
	public Disponibilite (Integer idDispo, String dateDebutDispo, String dateFinDispo,
			Boolean matin, Boolean apresMidi, Boolean affecte, Integer idEmploye){
		
		super();
		this.idDispo = idDispo;
		this.dateDebutDispo = dateDebutDispo;
		this.dateFinDispo = dateFinDispo;
		this.matin = matin;
		this.apresMidi = apresMidi;
		this.affecte = affecte;
		this.idEmploye = idEmploye;
	}

	//Getters and Setters
	public Integer getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(Integer idDispo) {
		this.idDispo = idDispo;
	}

	public String getDateDebutDispo() {
		return dateDebutDispo;
	}

	public void setDateDebutDispo(String dateDebutDispo) {
		this.dateDebutDispo = dateDebutDispo;
	}

	public String getDateFinDispo() {
		return dateFinDispo;
	}

	public void setDateFinDispo(String dateFinDispo) {
		this.dateFinDispo = dateFinDispo;
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

	public Boolean getAffecte() {
		return affecte;
	}

	public void setAffecte(Boolean affecte) {
		this.affecte = affecte;
	}

	public Integer getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(Integer idEmploye) {
		this.idEmploye = idEmploye;
	}
	
	
}
