package projet.holyweb.servlets;


import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;

import projet.holyweb.utils.*;

@WebServlet("/accueil")
public class ConnexionServlet extends AbstractGenericServlet{

	private static final long serialVersionUID = -3032812618526895052L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		TemplateEngine templateEngine = this.createTemplateEngine(req);
		
		resp.setCharacterEncoding("UTF-8");
		
		WebContext context = new WebContext(req, resp, req.getServletContext());

		templateEngine.process("Accueil", context, resp.getWriter());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
