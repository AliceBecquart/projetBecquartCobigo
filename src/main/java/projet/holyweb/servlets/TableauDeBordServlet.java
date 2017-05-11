package projet.holyweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet.holyweb.entities.Conge;
import projet.holyweb.entities.Disponibilite;
import projet.holyweb.entities.Employe;
import projet.holyweb.services.CongeService;
import projet.holyweb.services.DisponibiliteService;
import projet.holyweb.services.EmployeService;

@WebServlet("/tableauDeBord")
public class TableauDeBordServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Conge> listConge= CongeService.getInstance().Conge();
		context.setVariable("conge", listConge);
		
		List<Employe> listEmploye= EmployeService.getInstance().ListEmploye();
		context.setVariable("employe", listEmploye);
		
		List<Disponibilite> listDisponibilite= DisponibiliteService.getInstance().listDisponibilite();
		context.setVariable("disponibilite", listDisponibilite);
		
		templateEngine.process("tableauDeBord", context, resp.getWriter());
	}
	
}
