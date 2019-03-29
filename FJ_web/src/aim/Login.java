package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.*;
import business.*;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/menu.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Controller controller = new Controller();

		String userInput = request.getParameter("user");
		String passwordInput = request.getParameter("password");
		String nextPage;
		
		try {
Integer userDni = Integer.parseInt(userInput);
			
			if (controller.validateUser(userDni, passwordInput)) {
				HttpSession session = request.getSession(true);
				session.setAttribute("userSession", controller.getUser(userDni, passwordInput));
				nextPage = "menu";
			} else {
				nextPage = "login";
				request.setAttribute("errorMessage", "User DNI or password incorrect");
		
			}
			} catch (NumberFormatException e) {
			nextPage = "login";
			request.setAttribute("errorMessage", "Please enter only numbers in user (DNI)");
		}

		request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);
	}
}
