package projet.holyweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet.holyweb.entities.Disponibilite;
import projet.holyweb.entities.Employe;
import projet.holyweb.services.DisponibiliteService;
import projet.holyweb.services.EmployeService;

@WebServlet("/modificationDisponibilite")
public class ModificationDisponibiliteServlet extends AbstractGenericServlet{

	//Modifier une disponibilité
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Disponibilite> listDisponibilite= DisponibiliteService.getInstance().listDisponibilite();
		context.setVariable("disponibilite", listDisponibilite);
		
		List<Employe> listEmploye = EmployeService.getInstance().ListEmploye();
		context.setVariable("employe", listEmploye);
		
		templateEngine.process("modificationDisponibilite", context, resp.getWriter());
	}	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		String dateDebutDispo = req.getParameter("dateDebutDispo");
		String dateFinDispo = req.getParameter("dateFinDispo");
		Boolean matin = Boolean.parseBoolean(req.getParameter("matin"));
		Boolean apresMidi = Boolean.parseBoolean(req.getParameter("apresMidi"));
		Boolean affecte = Boolean.parseBoolean(req.getParameter("affecte"));
		Integer idEmploye = Integer.parseInt(req.getParameter("idEmploye"));
		
		DisponibiliteService.getInstance().updateDisponibilite(null, dateDebutDispo, dateFinDispo, matin, apresMidi, affecte, idEmploye);
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
	
}
