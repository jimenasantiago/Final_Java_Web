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

@WebServlet("/sellmedicine1")
public class Sellmedicine1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Sellmedicine1() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine1.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			Controller ctrl = new Controller();

			int healthPlanId = Integer.parseInt(request.getParameter("healthPlanId")); 
			HealthPlan hplan = new HealthPlan();
			hplan = ctrl.getHealthPlan(healthPlanId);

			Patient patient = new Patient();
			patient = ctrl.getPatient(Integer.parseInt(request.getParameter("affiliateNumberHP")));

			boolean answer = ctrl.validatecantmaxPrescription(healthPlanId, patient.getidPatient());
			if (answer) {
				System.out.println("Patient can buy medicine!");
				//saves the Patient in Session
				session.setAttribute("patient", patient);
				System.out.println("Patient name:" + patient.getname() + "Health Plan name" + hplan.getnameHP());
			} else {
				System.out.println("Patient can't buy medicine! Sorry");
			}
			
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine2.jsp").forward(request, response);
		}
	}
}
