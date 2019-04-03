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

@WebServlet("/seemedicinestockmin2")
public class Seemedicinestockmin2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Seemedicinestockmin2() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/seemedicinestockmin2.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
	
		String nextPage = "menu";

		if (loggedUser != null) {
			
			try {
				ArrayList<Item> items = new ArrayList<Item>();
				ArrayList<Medicine> medicines2 = new ArrayList<Medicine>();
				ArrayList<Presentation>pres2 = new ArrayList<Presentation>();
				int stockMin = Integer.parseInt(request.getParameter("stockMin")); 
				CtrlItem ctrlItem = new CtrlItem();
				items=ctrlItem.getItemsbyStock(stockMin);
				session.setAttribute("items2", items);
			CtrlMedicine ctrl = new CtrlMedicine();
			CtrlPresentation ctrlP = new CtrlPresentation();
			 for(int i=0;i<items.size();i++){
			  Medicine medicine = new Medicine();
			medicine = ctrl.getMedicineById(items.get(i).getIdmedicine());
			medicines2.add(i, medicine);
			Presentation pres = new Presentation();
			pres = ctrlP.getPresentationById(items.get(i).getIdpresentation());
			System.out.println(pres.getDescription());
			pres2.add(i, pres);
			 
			 }
			session.setAttribute("medicines2", medicines2);
			session.setAttribute("pres2", pres2);
    		nextPage = "seemedicinestockmin2";
    		//request.getRequestDispatcher("/WEB-INF/lib/sellmedicine4.jsp").forward(request, response);
		}
		
 catch (NumberFormatException e) {
	nextPage = "seemedicinestockmin1";
	request.setAttribute("errorMessage", "");
}
request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);

}}}
	