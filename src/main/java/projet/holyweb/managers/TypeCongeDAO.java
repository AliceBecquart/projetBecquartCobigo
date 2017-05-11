package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.TypeConge;

public class TypeCongeDAO {

		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion
	
	//Liste les types de congés existants dans la BDD
	public List<TypeConge> TypeConge(){
		
		List<TypeConge> TypeConge = new ArrayList<TypeConge>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM typeConge")){
			
					while (resultSet.next())
						TypeConge.add(new TypeConge(resultSet.getInt("idTypeConge"),
								resultSet.getString("libelleTypeConge")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return TypeConge;
	}

	//Donne un type de congé existant dans la BDD
	public TypeConge getTypeConge(Integer idTypeConge){
		
		TypeConge TypeConge = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM typeConge WHERE idTypeConge=?");
			stmt.setInt(1, idTypeConge);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				TypeConge = new TypeConge(
						resultSet.getInt("idTypeConge"),
						resultSet.getString("libelleTypeConge")	
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return TypeConge;
	}
	
	//Mise à jour d'un type de congé existant dans la BDD
	public void updateTypeConge(Integer idTypeConge, String libelleTypeConge){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE typeConge SET idTypeConge='"+idTypeConge+"',libelleTypeConge='"+libelleTypeConge+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'un nouveau type de congé existant dans la BDD
	public void addTypeConge(TypeConge TypeConges){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO typeConge(idTypeConge, libelleTypeConge) VALUES (?,?)");
		
			
			stmt.setInt(1, TypeConges.getIdTypeConge());
			stmt.setString(2, TypeConges.getLibelleTypeConge());
			
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'un type de congé existant dans la BDD
	public void deleteTypeConge(Integer idTypeConge){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM typeConge WHERE typeConge=?");
            stmt.setInt(1, idTypeConge);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
