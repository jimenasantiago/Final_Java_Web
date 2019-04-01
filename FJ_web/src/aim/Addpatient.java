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

@WebServlet("/addpatient")
public class Addpatient extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Addpatient() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			Controller controller = new Controller();
			CtrlHPlan ctrlHPlan = new CtrlHPlan();
			ArrayList<HealthPlan> healthPlans = new ArrayList<HealthPlan>();
			healthPlans = ctrlHPlan.getAllHealthPlan();
			request.setAttribute("hplans", healthPlans);
			request.getRequestDispatcher("/WEB-INF/lib/addpatient.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			CtrlPatient ctrl = new CtrlPatient();
			
			Patient patient = new Patient();
			patient.setname(request.getParameter("name"));
			patient.setsurname(request.getParameter("surname"));
			patient.setaffiliateNumberHP(Integer.parseInt(request.getParameter("affiliateNHP")));
			patient.setHealthPlanId(Integer.parseInt(request.getParameter("healthPlanId")));
			patient.setbirthdate(Integer.parseInt(request.getParameter("birthdate")));
			
			ctrl.addPatient(patient);
			request.getRequestDispatcher("/WEB-INF/lib/menu.jsp").forward(request, response);
		}
	}
}