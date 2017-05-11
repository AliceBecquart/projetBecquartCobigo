package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Conge;

public class CongeDAO {
	
		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion
	
	//Lister les congés existants dans la BDD
	public List<Conge> Conge(){
		
		List<Conge> Conge = new ArrayList<Conge>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM conge ORDER BY dateDebutConge")){
			
					while (resultSet.next())
						Conge.add(new Conge(resultSet.getInt("idConge"),
								resultSet.getString("dateDebutConge"),
								resultSet.getString("dateFinConge"),
								resultSet.getBoolean("matin"),
								resultSet.getBoolean("apresMidi"),
								resultSet.getString("numeroSemaineConge"),
								resultSet.getString("dateDemandeConge"),
								resultSet.getBoolean("demandeValide"),
								resultSet.getString("dateValidation"),
								resultSet.getInt("idTypeConge")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Conge;
	}

	//Donne un congé existant dans la BDD
	public Conge getConge(Integer idConge){
		
		Conge Conge = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM conge WHERE idConge=?");
			stmt.setInt(1, idConge);
			ResultSet resultSet = stmt.executeQuery();
			while(resultSet.next()){
				Conge = new Conge(
						resultSet.getInt("idConge"),
						resultSet.getString("dateDebutConge"),
						resultSet.getString("dateFinConge"),
						resultSet.getBoolean("matin"),
						resultSet.getBoolean("apresMidi"),
						resultSet.getString("numeroSemaineConge"),
						resultSet.getString("dateDemandeConge"),
						resultSet.getBoolean("demandeValide"),
						resultSet.getString("dateValidation"),
						resultSet.getInt("idTypeConge")
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Conge;
	}
	
	//Mise à jour d'un congé existant dans la BDD
	public void updateConge(Integer idConge, String dateDebutConge, String dateFinConge,
			Boolean matin, Boolean apresMidi, String numeroSemaineConge,
			String dateDemandeConge, Boolean demandeValide, String dateValidation,
			Integer idTypeConge){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE conge SET idConge='"+idConge+"',dateDebutConge='"+dateDebutConge+"', dateFinConge='"+dateFinConge+"', matin='"+matin+"', apresMidi='"+apresMidi+"', numeroSemaineConge='"+numeroSemaineConge+"', dateDemandeConge='"+dateDemandeConge+"', demandeValide='"+demandeValide+"', dateValidation='"+dateValidation+"', idTypeConge='"+idTypeConge+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'un nouveau congé existant dans la BDD
	public void addConge(Conge Conges){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO conge(idConge, dateDebutConge, dateFinConge, matin, apresMidi, numeroSemaineConge, dateDemandeConge, demandeValide, dateValidation, idTypeConge) VALUES (?,?,?,?,?,?,?,?,?,?)");
		
			
			stmt.setInt(1, Conges.getIdConge());
			stmt.setString(2,Conges.getDateDebutConge());
			stmt.setString(3,Conges.getDateFinConge());
			stmt.setBoolean(4, Conges.getMatin());
			stmt.setBoolean(5, Conges.getApresMidi());
			stmt.setString(6, Conges.getNumeroSemaineConge());
			stmt.setString(7, Conges.getDateDemandeConge());
			stmt.setBoolean(8, Conges.getDemandeValide());
			stmt.setString(9,Conges.getDateValidation());
			stmt.setInt(10, Conges.getIdConge());
			
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'un congé existant dans la BDD
	public void deleteConge(Integer idConge){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM conge WHERE conge=?");
            stmt.setInt(1, idConge);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
	
	//Valider Congé
	public void validerConge(Integer idConge){
		try {Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("UPDATE conge SET demandeValide = TRUE WHERE idConge=?");
			stmt.setInt(1, idConge);
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
	}
	
	//Congés à valider
	public List<Conge > listeConge(){
		
		List<Conge> listeConge = new ArrayList<Conge>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM conge ORDER BY dateDebutConge")){
			
					while (resultSet.next())
						listeConge.add(new Conge(resultSet.getInt("idConge"),
								resultSet.getString("dateDebutConge"),
								resultSet.getString("dateFinConge"),
								resultSet.getBoolean("matin"),
								resultSet.getBoolean("apresMidi"),
								resultSet.getString("numeroSemaineConge"),
								resultSet.getString("dateDemandeConge"),
								resultSet.getBoolean("demandeValide"),
								resultSet.getString("dateValidation"),
								resultSet.getInt("idTypeConge")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return listeConge;
	}
}



