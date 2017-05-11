package projet.holyweb.testCase;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.tuple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import projet.holyweb.dao.impl.DataSourceProvider;
import projet.holyweb.entities.Conge;
import projet.holyweb.managers.CongeDAO;

public class CongeTest {

	private CongeDAO congeDao = new CongeDAO();

	@Before
	public void initDb() throws Exception {
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
				Statement stmt = connection.createStatement()) {
			stmt.executeUpdate("DELETE FROM conge");
			stmt.executeUpdate("INSERT INTO `conge`(`idConge`,`dateDebutConge`,`dateFinConge`,`matin`,`apresMidi`,`numeroSemaineConge`,`dateDemandeConge`,`demandeValide`,`dateValidation`,`idTypeConge`) VALUES (1,'2017-06-12','2017-06-25',true,true,'S12','2017-03-15','','',1)");
			stmt.executeUpdate("INSERT INTO `conge`(`idConge`,`dateDebutConge`,`dateFinConge`,`matin`,`apresMidi`,`numeroSemaineConge`,`dateDemandeConge`,`demandeValide`,`dateValidation`,`idTypeConge`) VALUES (2,'2017-05-14','2017-05-14',true,false,'S12','2017-03-15','','',1)");
		}
	}
	
	@Test
	public void shouldListConges() {
		// WHEN
		List<Conge> conge = congeDao.listeConge();
		// THEN
		assertThat(conge).hasSize(2);
		assertThat(conge).extracting("idConge","dateDebutConge","dateFinConge","matin","apresMidi","numeroSemaineConge","dateDemandeConge","demandeValide","dateValidation","idTypeConge").containsOnly(tuple(1,"2017-06-12","2017-06-25",true,true,"S12","2017-03-15",null,null,1), tuple(2,"2017-05-14","2017-05-14",true,false,"S12","2017-03-15",null,null,1));
	}

	@Test
	public void shouldGetConges() {
		// WHEN
		Conge conge = congeDao.getConge(1);
		// THEN
		assertThat(conge).isNotNull();
		assertThat(conge.getIdConge()).isEqualTo(1);
		assertThat(conge.getDateDebutConge()).isEqualTo("2017-06-12");
		assertThat(conge.getDateFinConge()).isEqualTo("2017-06-25");
		assertThat(conge.getMatin()).isEqualTo(true);
		assertThat(conge.getApresMidi()).isEqualTo(true);
		assertThat(conge.getNumeroSemaineConge()).isEqualTo("S12");
		assertThat(conge.getDateDemandeConge()).isEqualTo("2017-03-15");
		assertThat(conge.getDemandeValide()).isEqualTo(null);
		assertThat(conge.getDateValidation()).isEqualTo(null);
		assertThat(conge.getIdTypeConge()).isEqualTo(1);
	}
	
	@Test
	public void shouldAddConge() throws Exception{
		//WHEN
		Conge newConge = new Conge(null,"2017-06-12","2017-06-25",true,true,"S12","2017-03-15",null,null,1);
		congeDao.addConge(newConge);
		
		//THEN 
		assertThat(newConge.getIdConge()).isNotNull();
		
		try (Connection connection = DataSourceProvider.getDataSource().getConnection();
			PreparedStatement stmt = connection.prepareStatement("SELECT * FROM conge WHERE idConge=?")){
			stmt.setInt(1, newConge.getIdConge());
			try(ResultSet rs = stmt.executeQuery()){
				assertThat(rs.next()).isTrue();
				assertThat(rs.getInt("idConge")).isEqualTo(newConge.getIdConge());
				assertThat(rs.getString("dateDebutConge")).isEqualTo("2017-06-12");
				assertThat(rs.getString("dateFinConge")).isEqualTo("2017-06-25");
				assertThat(rs.getBoolean("matin")).isEqualTo("true");
				assertThat(rs.getBoolean("apresMidi")).isEqualTo("true");
				assertThat(rs.getString("numeroSemaineConge")).isEqualTo("S12");
				assertThat(rs.getString("dateDemandeconge")).isEqualTo("2017-03-15");
				assertThat(rs.getString("demandeValide")).isNull();;
				assertThat(rs.getString("dateDemande")).isNull();;
				assertThat(rs.getInt("idTypeConge")).isEqualTo(1);
				assertThat(rs.next()).isFalse();
			}
		}
	}
	
}