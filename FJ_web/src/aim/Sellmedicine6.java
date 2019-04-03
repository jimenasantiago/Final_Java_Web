package aim;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.*;
import entities.*;

@WebServlet("/sellmedicine6")
public class Sellmedicine6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine6() {
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
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			CtrlItem ctrlItem = new CtrlItem();
			CtrlPrescription ctrlPrescription = new CtrlPrescription();
			CtrlPres_Item ctrlPres_Item = new CtrlPres_Item();
			Patient patient = (Patient) session.getAttribute("patient");
			Professional prof = (Professional) session.getAttribute("professional");
			Item item = (Item) session.getAttribute("itemsel");
		 	int cantItems = (int) session.getAttribute("cantItems");
			
			double total = cantItems * (double) item.getprice();
			Prescription p = new Prescription();
			p.setidItem(item.getidItem());
			p.setidpatient(patient.getidPatient());
			p.setidproffesional(prof.getidProffesional());
			Calendar date = Calendar.getInstance();
			Date prescdate = date.getTime();
			p.setprescriptionDate(prescdate);
			p.setTotal(total);
			int idPrescription;
			try {
				idPrescription = ctrlPrescription.setPrescription(p);
				Prescription_Item pi = new Prescription_Item();
				pi.setCantItem(cantItems);
				pi.setIdItem(item.getidItem());
				pi.setidPrescription(idPrescription);
				ctrlPres_Item.setPrescription_Item(pi);
				ctrlItem.updateCantItem(item, cantItems);
				request.getRequestDispatcher("/WEB-INF/lib/sellmedicine7.jsp").forward(request, response);
			
			
			} catch (SQLException e) {
				request.getRequestDispatcher("/WEB-INF/lib/sellmedicine6.jsp").forward(request, response);
				request.setAttribute("errorMessage", "Insuficient Items quantity");
				e.printStackTrace();
				
			}
			
		}
	}
}
