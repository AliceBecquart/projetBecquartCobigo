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

@WebServlet("/suppressionEmploye")
public class SuppressionEmployeServlet extends AbstractGenericServlet{

	//Supprimer un employé
	private static final long serialVersionUID = 1L;

	public static void Update(HttpServletRequest request, HttpServletResponse response) {
    }
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Employe> listEmploye= EmployeService.getInstance().ListEmploye();
		context.setVariable("employe", listEmploye);
		
		templateEngine.process("suppressionEmploye", context, resp.getWriter());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		Integer idEmploye = Integer.parseInt(req.getParameter("idEmploye"));
		EmployeService.getInstance().deleteEmploye(idEmploye);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
	
}
