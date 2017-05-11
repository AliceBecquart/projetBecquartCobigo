package projet.holyweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet.holyweb.entities.Categorie;
import projet.holyweb.entities.Conge;
import projet.holyweb.entities.Employe;
import projet.holyweb.services.CategorieService;
import projet.holyweb.services.CongeService;
import projet.holyweb.services.EmployeService;

@WebServlet("/modificationEmploye")
public class ModificationEmployeServlet extends AbstractGenericServlet{

	//Modifier un employé
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Employe> listEmploye= EmployeService.getInstance().ListEmploye();
		context.setVariable("employe", listEmploye);
		
		List<Categorie> listCategorie = CategorieService.getInstance().ListCategorie();
		context.setVariable("categorie", listCategorie);
		
		List<Conge> listConge = CongeService.getInstance().Conge();
		context.setVariable("conge", listConge);
		
		templateEngine.process("modificationEmploye", context, resp.getWriter());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		String mdpEmploye = req.getParameter("mdpEmploye");
		String dateNaissanceEmploye = req.getParameter("dateNaissanceEmploye");
		String nomEmploye = req.getParameter("nomEmploye");
		String prenomEmploye = req.getParameter("prenomEmploye");
		String telephoneEmploye = req.getParameter("telephoneEmploye");
		String mailEmploye = req.getParameter("mailEmploye");
		Boolean interimaire = Boolean.parseBoolean(req.getParameter("interimaire"));
		Integer idCategorie = Integer.parseInt(req.getParameter("idCategorie"));
		Integer idConge = Integer.parseInt(req.getParameter("idConge"));
		
		EmployeService.getInstance().updateEmploye(null, mdpEmploye, dateNaissanceEmploye, nomEmploye, prenomEmploye, telephoneEmploye, mailEmploye, interimaire, idCategorie, idConge);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
}
