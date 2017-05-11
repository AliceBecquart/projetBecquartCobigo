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
import projet.holyweb.services.CongeService;

@WebServlet("/ajoutConge")
public class AjoutCongeServlet extends AbstractGenericServlet{

	//Ajouter un congé
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Conge> listConge= CongeService.getInstance().Conge();
		context.setVariable("conge", listConge);
		
		templateEngine.process("DemandeCongeVU", context, resp.getWriter());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		String dateDebutConge = req.getParameter("dateDebutConge");
		String dateFinConge = req.getParameter("dateFinConge");
		Boolean matin = Boolean.parseBoolean(req.getParameter("matin"));
		Boolean apresMidi = Boolean.parseBoolean(req.getParameter("apresMidi"));
		
		Conge nouveauConge = new Conge(null,dateDebutConge,dateFinConge,matin,apresMidi,null,null, null,null,null);
		CongeService.getInstance().addConge(nouveauConge);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
}
