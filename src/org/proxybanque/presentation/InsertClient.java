package org.proxybanque.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.proxybanque.model.Client;
import org.proxybanque.services.OperationConseiller;

/**
 * *
 * @author O.AVCI  E.SAVARY
 * 
 * 		Servlet utilisée par la page InsererClient. Elle appelle le service OperationConseiller et la méthode saveClient.
 *  			
 */



/**
 * Servlet implementation class InsertClient
 */

@WebServlet("/InsertClient")
public class InsertClient extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertClient() {
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

		// Etape 1 : recupération des paramètres de la requête

		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String adresse = request.getParameter("adresse");
		String codePostal = request.getParameter("codePostal");
		String ville = request.getParameter("ville");
		String telephone = request.getParameter("telephone");
		String email = request.getParameter("email");
		int idConseiller = Integer.valueOf(request.getParameter("idConseiller"));
		OperationConseiller serviceConseiller = new OperationConseiller();

		// Création du Client à insérer

		Client client = new Client(nom, prenom, login, password, adresse, codePostal, ville, telephone, email,
				idConseiller);
		request.setAttribute("client", client);

		serviceConseiller.insertClient(client);

		// Etape 3 : Réponse à l'utilisateur

		response.sendRedirect("ListeDesClientsParConseiller.jsp");
	}

}
