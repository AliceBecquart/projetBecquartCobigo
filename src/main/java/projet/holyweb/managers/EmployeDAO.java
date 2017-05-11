package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Employe;

public class EmployeDAO {

		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion
	
	//Liste les employés existants dans la BDD
	public List<Employe> listEmploye(){
		
		List<Employe> Employe = new ArrayList<Employe>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM employe")){
			
					while (resultSet.next())
						Employe.add(new Employe(
								resultSet.getString("idEmploye"),
								resultSet.getString("mdpEmploye"),
								resultSet.getString("dateNaissanceEmploye"),
								resultSet.getString("nomEmploye"),
								resultSet.getString("prenomEmploye"),
								resultSet.getString("telephoneEmploye"),
								resultSet.getString("mailEmploye"),
								resultSet.getBoolean("interimaire"),
								resultSet.getInt("idCategorie"),
								resultSet.getInt("idConge")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Employe;
	}

	//Donne un employé existant dans la BDD
	public Employe getEmploye(String idEmploye){
		
		Employe Employe = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM employe WHERE idEmploye=?");
			stmt.setString(1, idEmploye);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				Employe = new Employe(
						resultSet.getString("idEmploye"),
						resultSet.getString("mdpEmploye"),
						resultSet.getString("dateNaissanceEmploye"),
						resultSet.getString("nomEmploye"),
						resultSet.getString("prenomEmploye"),
						resultSet.getString("telephoneEmploye"),
						resultSet.getString("mailEmploye"),
						resultSet.getBoolean("interimaire"),
						resultSet.getInt("idCategorie"),
						resultSet.getInt("idConge")
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Employe;
	}
	
	//Mise à jour d'un employé existant dans la BDD
	public void updateEmploye(String idEmploye, String mdpEmploye, String dateNaissanceEmploye,
			String nomEmploye, String prenomEmploye, String telephoneEmploye,
			String mailEmploye, Boolean interimaire, Integer idCategorie,
			Integer idConge){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE employe SET idEmploye='"+idEmploye+"',mdpEmploye='"+mdpEmploye+"', dateNaissanceEmploye='"+dateNaissanceEmploye+"', nomEmploye='"+nomEmploye+"', prenomEmploye='"+prenomEmploye+"', telephoneEmploye='"+telephoneEmploye+"', mailEmploye='"+mailEmploye+"', interimaire='"+interimaire+"',idCategorie='"+idCategorie+"', idConge='"+idConge+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'un nouvel employé dans la BDD
	public void addEmploye(Employe Employes){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO employe(idEmploye, mdpEmploye, dateNaissanceEmploye, nomEmploye, prenomEmploye, telephoneEmploye, mailEmploye, interimaire, idCategorie, idConge) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
			
			stmt.setString(1, Employes.getIdEmploye());
			stmt.setString(2, Employes.getMdpEmploye());
			stmt.setString(3, Employes.getDateNaissanceEmploye());
			stmt.setString(4, Employes.getNomEmploye());
			stmt.setString(5, Employes.getPrenomEmploye());
			stmt.setString(6, Employes.getTelephoneEmploye());
			stmt.setString(7, Employes.getMailEmploye());
			stmt.setBoolean(8, Employes.getInterimaire());
			stmt.setInt(9,Employes.getIdCategorie());
			stmt.setInt(10, Employes.getIdConge());
		

			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'un employé existant dans la BDD
	public void deleteEmploye(Integer idEmploye){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM employe WHERE employe=?");
            stmt.setInt(1, idEmploye);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
