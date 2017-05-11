package projet.holyweb.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import projet.holyweb.entities.Employe;
import projet.holyweb.services.EmployeService;


@WebServlet("/ajoutEmploye")
public class AjoutEmployeServlet extends AbstractGenericServlet {

	//Ajouter un employe
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Employe> listEmploye= EmployeService.getInstance().ListEmploye();
		context.setVariable("employe", listEmploye);
		
		templateEngine.process("ajoutEmploye", context, resp.getWriter());
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
		
		Employe nouvelEmploye = new Employe(null,mdpEmploye,dateNaissanceEmploye,nomEmploye,prenomEmploye,telephoneEmploye,mailEmploye,interimaire,null,null);
		EmployeService.getInstance().addEmploye(nouvelEmploye);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}

}
