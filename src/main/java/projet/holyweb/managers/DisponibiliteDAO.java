package projet.holyweb.managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Disponibilite;

public class DisponibiliteDAO {

		//Implémentation des méthodes
	//création et utilisation d'une connexion,récupération et gestion des paramètres, fermture de connexion
	
	//Liste les disponibilités existantes dans la BDD
	public List<Disponibilite> listDisponibilite(){
		
		List<Disponibilite> Disponibilite = new ArrayList<Disponibilite>();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT * FROM disponibilite")){
			
					while (resultSet.next())
						Disponibilite.add(new Disponibilite(
								resultSet.getInt("idDispo"),
								resultSet.getString("dateDebutDispo"),
								resultSet.getString("dateFinDispo"),
								resultSet.getBoolean("matin"),
								resultSet.getBoolean("apresMidi"),
								resultSet.getBoolean("affecte"),
								resultSet.getInt("idEmploye")
								));
					}
	
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		return Disponibilite;
	}

	//Liste les disponibilités non affectées existantes dans la BDD
		public List<Disponibilite> listDisponibiliteNA(){
			
			List<Disponibilite> listeDisponibiliteNA = new ArrayList<Disponibilite>();
			
			try (Connection connection = DataSourceProvider.getDataSource().getConnection();
					Statement statement = connection.createStatement();
					ResultSet resultSet = statement.executeQuery("SELECT * FROM disponibilite WHERE affecte = FALSE")){
				
						while (resultSet.next())
							listeDisponibiliteNA.add(new Disponibilite(
									resultSet.getInt("idDispo"),
									resultSet.getString("dateDebutDispo"),
									resultSet.getString("dateFinDispo"),
									resultSet.getBoolean("matin"),
									resultSet.getBoolean("apresMidi"),
									resultSet.getBoolean("affecte"),
									resultSet.getInt("idEmploye")
									));
						}
		
			catch (SQLException e) {
				e.printStackTrace();
			}
			
			return listeDisponibiliteNA;
		}
		
	//Donne une disponibilité existante dans la BDD
	public Disponibilite getDisponibilite(Integer idDisponibilite){
		
		Disponibilite Disponibilite = null;
		
		try{
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM disponibilite WHERE idDisponibilite=?");
			stmt.setInt(1, idDisponibilite);
			ResultSet resultSet = stmt.executeQuery();
			if(resultSet.next()){
				Disponibilite = new Disponibilite(
						resultSet.getInt("idDispo"),
						resultSet.getString("dateDebutDispo"),
						resultSet.getString("dateFinDispo"),
						resultSet.getBoolean("matin"),
						resultSet.getBoolean("apresMidi"),
						resultSet.getBoolean("affecte"),
						resultSet.getInt("idEmploye")
						);
			}
			stmt.close();
			connection.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		return Disponibilite;
	}
	
	//Mise à jour d'une disponibilité existante dans la BDD
	public void updateDisponibilite(Integer idDispo, String dateDebutDispo,String dateFinDispo,
			Boolean matin, Boolean apresMidi, Boolean affecte, Integer idEmploye){
		
		try (Connection connection =DataSourceProvider.getDataSource().getConnection();
				PreparedStatement statement = connection.prepareStatement("UPDATE disponibilite SET idDispo='"+idDispo+"',dateDebutDispo='"+dateDebutDispo+"', dateFinDispo='"+dateFinDispo+"', matin='"+matin+"', apresMidi='"+apresMidi+"', affecte='"+affecte+"', idEmploye='"+idEmploye+"'")){	
				statement.executeUpdate();
			} catch (SQLException e){
				e.printStackTrace();
			}
		
	}
	
	
	//Ajout d'une nouvelle disponibilité dans la BDD
	public void addDisponibilite(Disponibilite Disponibilites){
		try {
			Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("INSERT INTO disponibilite(idDispo, dateDebutDispo, dateFinDispo, matin, apresMidi, affecte, idEmploye) VALUES (?,?,?,?,?,?,?)");
		
			
			stmt.setInt(1, Disponibilites.getIdDispo());
			stmt.setString(2,Disponibilites.getDateDebutDispo());
			stmt.setString(3,Disponibilites.getDateFinDispo());
			stmt.setBoolean(4, Disponibilites.getMatin());
			stmt.setBoolean(5, Disponibilites.getApresMidi());
			stmt.setBoolean(6, Disponibilites.getAffecte());
			stmt.setInt(7, Disponibilites.getIdEmploye());
			
			stmt.executeUpdate();
			stmt.close();
			
			connection.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		
	}
	
	//Suppression d'une disponibilité existante dans la BDD
	public void deleteDisponibilite(Integer idDispo){
		
		try {
            Connection connection = DataSourceProvider.getDataSource().getConnection();
            PreparedStatement stmt = connection.prepareStatement("DELETE FROM disponibilite WHERE disponibilite=?");
            stmt.setInt(1, idDispo);
            stmt.executeUpdate();
            stmt.close();
            
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
		
	}
}
