package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.User;

@WebServlet("/sellmedicine7")
public class Sellmedicine7 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine7() {
		super();
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null && loggedUser.getType()=="Admin") {
			request.getRequestDispatcher("/WEB-INF/lib/menu.jsp").forward(request, response);
		} else if (loggedUser != null && loggedUser.getType()=="User")	
		{request.getRequestDispatcher("/WEB-INF/lib/menu2.jsp").forward(request, response);}
		else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null && loggedUser.getType()=="Admin") {
			request.getRequestDispatcher("/WEB-INF/lib/menu.jsp").forward(request, response);
		} else if (loggedUser != null && loggedUser.getType()=="User")	
		{request.getRequestDispatcher("/WEB-INF/lib/menu2.jsp").forward(request, response);}
		else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
		
		
		//doGet(request, response);
	}
}
