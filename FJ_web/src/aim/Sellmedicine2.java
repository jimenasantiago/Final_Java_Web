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

@WebServlet("/sellmedicine2")
public class Sellmedicine2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine2.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		
		try{ 
		
		if (loggedUser != null) {
			CtrlMedicine ctrl = new CtrlMedicine();
			CtrlGDrug ctrlgdrug = new CtrlGDrug();
			
			GenericDrug gdrug = new GenericDrug();
			gdrug = ctrlgdrug.getGenericDrug(request.getParameter("gDrugName"));
			
			ArrayList<Medicine> medicines = new ArrayList<Medicine>();
			medicines = ctrl.getMedicineByDrug(gdrug.getidDrug());
			
			request.setAttribute("medicines", medicines);
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine3.jsp").forward(request, response);
		}
		
		} catch (NumberFormatException e) {
			
			request.setAttribute("errorMessage", "Please enter only numbers in user (DNI)");
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
	}
}}