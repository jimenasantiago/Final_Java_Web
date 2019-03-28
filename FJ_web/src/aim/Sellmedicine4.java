package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;
import entities.*;

@WebServlet("/sellmedicine4")
public class Sellmedicine4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine4.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			Controller ctrl = new Controller();
			Medicine medicine = (Medicine) session.getAttribute("medicine");
			Item item = new Item();
			item = ctrl.getItem(medicine.getidMedicine(), Integer.parseInt(request.getParameter("idPresentation")));
			
			Professional prof = new Professional();
			prof = ctrl.getProfessional(Integer.parseInt(request.getParameter("regNumberP")));
			
			session.setAttribute("professional", prof);
			session.setAttribute("itemsel", item);
			request.setAttribute("item", item);
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine5.jsp").forward(request, response);
		}
	}
}