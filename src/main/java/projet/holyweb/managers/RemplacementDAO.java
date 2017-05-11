package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Remplacement;

public class RemplacementDAO {
	
		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion
	
	//Liste les remplacements existants dans la BDD
	public List<Remplacement> listRemplacement(){
		
		List<Remplacement> Remplacement = new ArrayList<Remplacement>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM remplacement")){
			
					while (resultSet.next())
						Remplacement.add(new Remplacement(
								resultSet.getInt("idRemplacement"),
								resultSet.getInt("idEmployeRemplacant"),
								resultSet.getInt("idEmployeRemplace"),
								resultSet.getInt("idDispo")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Remplacement;
	}

	//Donne un remplacement existant dans la BDD
	public Remplacement getRemplacement(Integer idRemplacement){
		
		Remplacement Remplacement = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM remplacement WHERE idRemplacement=?");
			stmt.setInt(1, idRemplacement);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				Remplacement = new Remplacement(
						resultSet.getInt("idRemplacement"),
						resultSet.getInt("idEmployeRemplacant"),
						resultSet.getInt("idEmployeRemplace"),
						resultSet.getInt("idDispo")
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Remplacement;
	}
	
	//Mise à jour d'un remplacement existant dans la BDD
	public void updateRemplacement(Integer idRemplacement, Integer idEmployeRemplacant, Integer idEmployeRemplace,
			Integer idDispo){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE remplacement SET idRemplacement='"+idRemplacement+"',idEmployeRemplacant='"+idEmployeRemplacant+"', idEmployeRemplace='"+idEmployeRemplace+"', idDispo='"+idDispo+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'un nouveau remplacement dans la BDD
	public void addRemplacement(Remplacement Remplacements){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO remplacement(idRemplacement, idEmployeRemplacant, idEmployeRemplace, idDispo) VALUES (?,?,?,?)");
		
			
			stmt.setInt(1, Remplacements.getIdRemplacement());
			stmt.setInt(2, Remplacements.getIdEmployeRemplacant());
			stmt.setInt(3, Remplacements.getIdEmployeRemplace());
			stmt.setInt(7, Remplacements.getIdDispo());
			
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'un remplacement existant dans la BDD
	public void deleteRemplacement(Integer idRemplacement){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM remplacement WHERE idRemplacement=?");
            stmt.setInt(1, idRemplacement);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
