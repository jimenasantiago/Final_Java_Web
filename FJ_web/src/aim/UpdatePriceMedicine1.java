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

@WebServlet("/updatepricemedicine1")
public class UpdatePriceMedicine1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpdatePriceMedicine1() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/updatepricemedicine1.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			
			
			String nextPage = "menu";
			try {
			CtrlMedicine ctrlMedicine = new CtrlMedicine();
			double percent = Double.parseDouble(request.getParameter("percentMedicine"));
			
			ctrlMedicine.updatePriceMedicines(percent);
						
			
			} catch (NumberFormatException e) {
				nextPage = "updatepricemedicine1";
				request.setAttribute("errorMessage", "Please insert correct data");
			}
			request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);
			
		}
	}
}


