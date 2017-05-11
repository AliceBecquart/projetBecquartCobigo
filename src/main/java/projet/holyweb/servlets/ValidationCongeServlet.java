package projet.holyweb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import projet.holyweb.services.CongeService;

@WebServlet("/validationConge")
public class ValidationCongeServlet extends AbstractGenericServlet{
	
	//Valider un congé
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException{
		
		Integer idConge = Integer.parseInt(req.getParameter("idConge"));
		CongeService.getInstance().validerConge(idConge);
		//req.getSession().removeAttribute(idConge);
		
		//templateEngine.process("validationConge", context, resp.getWriter());
		resp.sendRedirect("TableauDeBord");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		//System.out.println("Le congé a bien été validé");
	}
}
