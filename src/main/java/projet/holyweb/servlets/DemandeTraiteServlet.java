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

@WebServlet("/listeConge")
public class DemandeTraiteServlet extends AbstractGenericServlet {

	//Lister les congés en attente (non validés/non supprimés)
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		WebContext context = new WebContext(req, resp, req.getServletContext());
		
        List<Conge> conges = CongeService.getInstance().Conge();
        context.setVariable("conges", conges);
            	
        templateEngine.process("DemandeTraiteVA", context, resp.getWriter());
    }
}
