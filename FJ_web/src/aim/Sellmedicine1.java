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
			CtrlPatient ctrlPatient = new CtrlPatient();
			CtrlHPlan ctrlHPlan = new CtrlHPlan();
			CtrlPrescription ctrlPrescription = new CtrlPrescription();
			int healthPlanId = Integer.parseInt(request.getParameter("healthPlanId")); 
			HealthPlan hplan = new HealthPlan();
			hplan = ctrlHPlan.getHealthPlan(healthPlanId);
			String nextPage;

			Patient patient = new Patient();
			patient = ctrlPatient.getPatient(Integer.parseInt(request.getParameter("affiliateNumberHP")));
			System.out.println("Patient id HP:" + patient.getHealthPlanId());
			
			try {
			boolean answer = ctrlPrescription.validatecantmaxPrescription(patient.getHealthPlanId(), patient.getidPatient());
		    
		    
			
			if (answer && (patient.getname() != null) ) {
				System.out.println("Patient can buy medicine!");
				nextPage = "sellmedicine2";
				session.setAttribute("patient", patient);
				System.out.println("Patient name:" + patient.getname() + "Health Plan name" + hplan.getnameHP());
			} else {
				System.out.println("Patient can't buy medicine! Sorry");
				nextPage = "sellmedicine1";
				request.setAttribute("errorMessage", "Patient incorrect");
			} 
						
			
			} catch (NumberFormatException e) {
				nextPage = "sellmedicine1";
				request.setAttribute("errorMessage", "Please insert correct data");
			}
			request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);
			
		}
	}
}








