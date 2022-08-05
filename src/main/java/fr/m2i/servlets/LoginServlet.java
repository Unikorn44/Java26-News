package fr.m2i.servlets;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import fr.m2i.models.News;
import fr.m2i.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String LOGINPAGE="/WEB-INF/pages/login.jsp";
	private static final String ACCUEILPAGE="/welcome";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String isLogoff = request.getParameter("logoff");
		System.out.println(isLogoff);
		if(isLogoff != null && !isLogoff.isEmpty() && isLogoff.equals("true")) {
			logoff(request);
			this.getServletContext().getRequestDispatcher(ACCUEILPAGE).forward(request, response);
		}else {
			this.getServletContext().getRequestDispatcher(LOGINPAGE).forward(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		User user = em.createNamedQuery("findUserRole", User.class)
				.setParameter("un", username)
				.setParameter("up", password)
				.getSingleResult();
		
		if(user.getAdmin()) {
			session.setAttribute("auth", true);
			session.setAttribute("user", user);
			System.out.println("je suis connectée");
		} else {
			System.out.println("Pas admin");
		}
		
		response.sendRedirect(request.getContextPath() + ACCUEILPAGE);
		
	}
	
	protected void logon(String login, String mdp, HttpServletRequest request) {
		/* RAJOUTER UNE VERIF */
		HttpSession session = request.getSession();
		
		session.setAttribute("auth", true);
	}
	protected void logoff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		session.removeAttribute("auth");
		session.removeAttribute("user");
	}
	
}
