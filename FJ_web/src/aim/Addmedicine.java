package aim;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;
import entities.*;

@WebServlet("/addmedicine")
public class Addmedicine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Addmedicine() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			Controller controller = new Controller();
			ArrayList<GenericDrug> genericDrugs = new ArrayList<GenericDrug>();
			genericDrugs = controller.getAllGenericDrug();
			request.setAttribute("gdrugs", genericDrugs);
			request.getRequestDispatcher("/WEB-INF/lib/addmedicine.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			Controller ctrl = new Controller();

			Medicine medicine = new Medicine();
			medicine.setname(request.getParameter("name"));
			medicine.setdescription(request.getParameter("description"));
			
			GenericDrug gdrug = new GenericDrug();
			gdrug.setidDrug(Integer.parseInt(request.getParameter("iddrug")));
			
			medicine.setgenericDrugs(gdrug);
			ctrl.addMedicine(medicine);
			
			request.getRequestDispatcher("/WEB-INF/lib/addmedicine.jsp").forward(request, response);
		}
	}
}