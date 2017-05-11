package projet.holyweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.holyweb.services.CongeService;


@WebServlet("/suppConge")
public class SuppressionCongeServlet extends AbstractGenericServlet{

	//Supprimer un congé
	private static final long serialVersionUID = 1L;

	public static void Update(HttpServletRequest request, HttpServletResponse response) {
	}
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		int idConge = Integer.parseInt(req.getParameter("idConge"));
		CongeService.getInstance().deleteConge(idConge);
		req.getSession().removeAttribute("idConge");
		
		//templateEngine.process("suppressionEmploye", context, resp.getWriter());
		resp.sendRedirect("DemandeTraiteVA");
	}
}
