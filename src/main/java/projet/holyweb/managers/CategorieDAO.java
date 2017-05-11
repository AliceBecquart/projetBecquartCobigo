package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Categorie;

public class CategorieDAO {

		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion  

	//Liste les catégories d'employé existantes dans la BDD
	public List<Categorie> listCategorie(){
		
		List<Categorie> Categorie = new ArrayList<Categorie>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie")){
			
					while (resultSet.next())
						Categorie.add(new Categorie(resultSet.getInt("idCategorie"),
								resultSet.getString("libelleCategorie")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Categorie;
	}

	//Donne une catégorie d'employé existant dans la BDD
	public Categorie getCategorie(Integer idCategorie){
		
		Categorie Categorie = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM categorie WHERE idCategorie=?");
			stmt.setInt(1, idCategorie);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				Categorie = new Categorie(
						resultSet.getInt("idCategorie"),
						resultSet.getString("libelleCategorie")	
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Categorie;
	}
	
	//Mise à jour d'une categorie d'employé existante dans la BDD
	public void updateCategorie(Integer idCategorie, String libelleCategorie){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE categorie SET idCategorie='"+idCategorie+"',libelleCategorie='"+libelleCategorie+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'une nouvelle categorie d'employé dans la BDD
	public void addCategorie(Categorie Categories){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO categorie(idCategorie, libelleCategorie) VALUES (?,?)");
		
			
			stmt.setInt(1, Categories.getIdCategorie());
			stmt.setString(2, Categories.getLibelleCategorie());
			
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'une categorie d'employé existante dans la BDD
	public void deleteCategorie(Integer idCategorie){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM categorie WHERE categorie=?");
            stmt.setInt(1, idCategorie);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
