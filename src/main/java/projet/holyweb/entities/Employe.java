package projet.holyweb.entities;


public class Employe {
	
	//Définiton d'un employe
	private String idEmploye;
	private String mdpEmploye;
	private String dateNaissanceEmploye;
	private String nomEmploye;
	private String prenomEmploye;
	private String telephoneEmploye;
	private String mailEmploye;
	private Boolean interimaire;
	private Integer idCategorie;
	private Integer idConge;
	
	public Employe(String idEmploye,String mdpEmploye,String dateNaissanceEmploye, 
			String nomEmploye, String prenomEmploye, String telephoneEmploye,
			String mailEmploye, Boolean interimaire, Integer idCategorie,
			Integer idConge){
		
		super();
		this.idEmploye = idEmploye;
		this.mdpEmploye = mdpEmploye;
		this.dateNaissanceEmploye = dateNaissanceEmploye;
		this.nomEmploye = nomEmploye;
		this.prenomEmploye = prenomEmploye;
		this.telephoneEmploye = telephoneEmploye;
		this.mailEmploye = mailEmploye;
		this.interimaire = interimaire;
		this.idCategorie = idCategorie;
		this.idConge = idConge;
	}

	//Getters and Setters
	public String getIdEmploye() {
		return idEmploye;
	}

	public void setIdEmploye(String idEmploye) {
		this.idEmploye = idEmploye;
	}

	public String getMdpEmploye() {
		return mdpEmploye;
	}

	public void setMdpEmploye(String mdpEmploye) {
		this.mdpEmploye = mdpEmploye;
	}

	public String getDateNaissanceEmploye() {
		return dateNaissanceEmploye;
	}

	public void setDateNaissanceEmploye(String dateNaissanceEmploye) {
		this.dateNaissanceEmploye = dateNaissanceEmploye;
	}

	public String getNomEmploye() {
		return nomEmploye;
	}

	public void setNomEmploye(String nomEmploye) {
		this.nomEmploye = nomEmploye;
	}

	public String getPrenomEmploye() {
		return prenomEmploye;
	}

	public void setPrenomEmploye(String prenomEmploye) {
		this.prenomEmploye = prenomEmploye;
	}

	public String getTelephoneEmploye() {
		return telephoneEmploye;
	}

	public void setTelephoneEmploye(String telephoneEmploye) {
		this.telephoneEmploye = telephoneEmploye;
	}

	public String getMailEmploye() {
		return mailEmploye;
	}

	public void setMailEmploye(String mailEmploye) {
		this.mailEmploye = mailEmploye;
	}

	public Boolean getInterimaire() {
		return interimaire;
	}

	public void setInterimaire(Boolean interimaire) {
		this.interimaire = interimaire;
	}

	public Integer getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Integer idCategorie) {
		this.idCategorie = idCategorie;
	}

	public Integer getIdConge() {
		return idConge;
	}

	public void setIdConge(Integer idConge) {
		this.idConge = idConge;
	}
	
}


