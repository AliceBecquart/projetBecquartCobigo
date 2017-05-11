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
import projet.holyweb.entities.TypeConge;
import projet.holyweb.services.CongeService;
import projet.holyweb.services.TypeCongeService;

@WebServlet("/attenteCongeVU")
public class ModificationCongeServlet extends AbstractGenericServlet {
	
	//Modification d'un congé
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Conge> listConge= CongeService.getInstance().Conge();
		context.setVariable("conge", listConge);
		
		List<TypeConge> listTypeConge = TypeCongeService.getInstance().TypeConge();
		context.setVariable("typeConge", listTypeConge);
		
		templateEngine.process("ReservationVU", context, resp.getWriter());
	}	
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		String dateDebutConge = req.getParameter("dateDebutConge");
		String dateFinConge = req.getParameter("dateFinConge");
		Boolean matin = Boolean.parseBoolean(req.getParameter("matin"));
		Boolean apresMidi = Boolean.parseBoolean(req.getParameter("apresMidi"));
		String numeroSemaineConge = req.getParameter("numeroSemaineConge");
		String dateDemandeConge = req.getParameter("dateDemandeConge");
		Boolean demandeValide = Boolean.parseBoolean("demandeValide");
		String dateValidation = req.getParameter("dateValidation");
		Integer idTypeConge = Integer.parseInt(req.getParameter("idTypeConge"));
		
		CongeService.getInstance().updateConge(null, dateDebutConge, dateFinConge, matin, apresMidi, numeroSemaineConge, dateDemandeConge, demandeValide, dateValidation, idTypeConge);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
	
	
}
