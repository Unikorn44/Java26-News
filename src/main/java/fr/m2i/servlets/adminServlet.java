package fr.m2i.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.models.News;
import fr.m2i.models.User;

/**
 * Servlet implementation class adminServlet
 */
@WebServlet("/admin")
public class adminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGE = "/WEB-INF/pages/admin.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		EntityManager em = factory.createEntityManager();

		String option = request.getParameter("formulaire");
		
		em.getTransaction().begin();
		boolean transac = false;
		
		try {			
			if(option.equals("ajoutnews")) {
				String titre = request.getParameter("titre");
				String description = request.getParameter("description");
				String dateArticle = date();
				em.createNativeQuery("INSERT INTO newstable (dateArticle, titre, description) VALUES(?1, ?2, ?3)")			
					.setParameter(1, dateArticle)
					.setParameter(2, titre)
					.setParameter(3, description)
					.executeUpdate();
				transac = true;
			}
			
			if(option.equals("ajoutuser")) {
				String nom = request.getParameter("nom");
				String prenom = request.getParameter("prenom");
				Boolean admin = true;
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				em.createNativeQuery("INSERT INTO usertable (nom, prenom, admin, username, password) VALUES(?1, ?2, ?3, ?4, ?5)")			
					.setParameter(1, nom)
					.setParameter(2, prenom)
					.setParameter(5, username)
					.setParameter(4, password)
					.setParameter(3, admin)
					.executeUpdate();
				transac = true;
			}
			
		} finally {
			
			if(transac) {
				em.getTransaction().commit();
			}else {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		
		doGet(request, response);
	}
	

	private String date() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		  Date date = new Date();
		  return (dateFormat.format(date));
	}

}
