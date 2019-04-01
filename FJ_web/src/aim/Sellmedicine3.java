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

@WebServlet("/sellmedicine3")
public class Sellmedicine3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine3() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine3.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		String nextPage = "login";

		if (loggedUser != null) {
			
			try {
				
			CtrlMedicine ctrl = new CtrlMedicine();
			CtrlPresentation ctrlP = new CtrlPresentation();
			
			Medicine medicine = new Medicine();
			medicine = ctrl.getMedicineByName(request.getParameter("medicineName"));
			
			ArrayList<Presentation> pres = new ArrayList<Presentation>();
			pres = ctrlP.getPresentationByMedicine(medicine.getidMedicine());
			
			session.setAttribute("medicine", medicine);
    		request.setAttribute("pres", pres);
    		nextPage = "sellmedicine4";
    		//request.getRequestDispatcher("/WEB-INF/lib/sellmedicine4.jsp").forward(request, response);
		}
		
 catch (NumberFormatException e) {
	nextPage = "sellmedicine3";
	request.setAttribute("errorMessage", "");
}
request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);

}}}
	
