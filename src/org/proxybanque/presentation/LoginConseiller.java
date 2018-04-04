package org.proxybanque.presentation;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 		Servlet utilis�e par la page Acceuil.
 * 		Elle appelle le service OperationConseiller et la m�thode verificationLoginPassword.
 *  			
 */

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;

import org.proxybanque.model.Conseiller;
import org.proxybanque.persistance.DaoConseillerImp;
import org.proxybanque.services.*;

/**
 * Servlet implementation class LoginConseiller
 */
@WebServlet("/LoginConseiller")
public class LoginConseiller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginConseiller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// R�cup�ration du login et du password

		String loginFormulaire = request.getParameter("loginFormulaire");
		String passwordFormulaire = request.getParameter("passwordFormulaire");
		OperationConseiller daoConseiller = new OperationConseiller();
		

		// cr�ation du conseiller et v�rification du login et password

		Conseiller conseiller = new Conseiller(loginFormulaire, passwordFormulaire);
		request.setAttribute("conseiller", conseiller);

		// r�ponses et redirection selon r�sultat

		RequestDispatcher dispatcher;
		

		String path = "";
		if (daoConseiller.verificationLoginPassword(loginFormulaire, passwordFormulaire) == true) {

			path = "ListeDesClientsParConseiller.jsp";

		} else {

			path = "EchecAuthentification.jsp";
		}

		dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

	// dans la JSP pour afficher le r�sultat : <li> le departement pour
	// "${paire.deptNum}" est ..

}
