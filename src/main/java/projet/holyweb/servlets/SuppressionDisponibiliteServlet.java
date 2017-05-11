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
import projet.holyweb.services.DisponibiliteService;

@WebServlet("/suppressionDisponibilite")
public class SuppressionDisponibiliteServlet extends AbstractGenericServlet{
	
	//Supprimer une disponibilité
	private static final long serialVersionUID = 1L;
	
	public static void Update(HttpServletRequest request, HttpServletResponse response) {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
		List<Disponibilite> listDisponibilite= DisponibiliteService.getInstance().listDisponibilite();
		context.setVariable("disponibilite", listDisponibilite);
		
		templateEngine.process("suppressionDiponibilite", context, resp.getWriter());
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		
		Integer idDispo = Integer.parseInt(req.getParameter("idDispo"));
		DisponibiliteService.getInstance().deleteDisponibilite(idDispo);
		
		resp.setCharacterEncoding("UTF-8");
		resp.sendRedirect("TableauDeBord");
	}
}
