package projet.holyweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.holyweb.entities.Disponibilite;
import projet.holyweb.services.DisponibiliteService;

@WebServlet("/DisponibilitesNA")
public class CongesDisponiblesServlet extends AbstractGenericServlet{

	//Liste des disponibilités non affectées
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		
		List<Disponibilite> listDisponibiliteNA = DisponibiliteService.getInstance().listDisponibiliteNA();
		req.setAttribute("DisponibiliteNA", listDisponibiliteNA);
	} 
}
