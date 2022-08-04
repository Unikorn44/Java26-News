package fr.m2i.servlets;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.m2i.models.Actor;

/**
 * Servlet implementation class WelcomeServlet
 */
@WebServlet("/welcome")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String PAGE="/WEB-INF/pages/welcome.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("actor", this.jpaExemple());
		
		
		this.getServletContext().getRequestDispatcher(PAGE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	//méthode pour retrouver UN acteur via ccès direct des données
	protected Actor jpaExemple() {
		//Création EntityFactoryManager pour les lier tous
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("UnityPersist");
		//Attention pas d'autoclosable
		EntityManager em = factory.createEntityManager();
		
		
		/*
		    find -- attache l'entité à EM + détecte toutes les modif° effectuées
			persist -- ajout d'une nouvelle entité dans la BDD
			merge -- Appliquer des modifications en BDD pour une entité NON managée (exp: new actor)
			detach -- sort du contexte d esurveillance / zone de responsabilité de l'EM
			refresh
			remove -- supprime de la BDD
		 */
		//Présence du EM.FIND => surveillance par EM
		Actor actor = em.find(Actor.class, 1); //-- attache l'entité à EM
		//em.persist(nouvel actor)
		//em.remove(un actor)
		//em.refresh(entity) -- pour rafraichir avec la data en bdd
		//em.detach(entity) -- DETACHE du contexte de responsabilité de l'EM
		//em.flush() ---- Attention ! OBLIGE le EM à METTRE A JOUR la BDD (sans vérifications)
		
		 
		
		/*
		 * Transaction
		 * 
		 * em.getTransaction().begin()
		 * boolean transcat = false;
		 * 
		 * try{
		 * 
		 * }
		 * finally{
		 * 	if(transac)
		 * 		em.getTransaction().commit();
		 * 	else
		 * 		em.getTransaction().rollback();
		 * 
		 * }
		 */
		
		
		em.close();
		
		return actor;
	}

}
