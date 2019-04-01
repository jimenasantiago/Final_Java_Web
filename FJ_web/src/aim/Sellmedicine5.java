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

@WebServlet("/sellmedicine5")
public class Sellmedicine5 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine5() {
		super();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine5.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		Professional prof = session != null ? (Professional) session.getAttribute("professional") : null;
		if (loggedUser != null && prof.getname() !=null) {
			CtrlItem ctrlItem = new CtrlItem();
			int cantItems = Integer.parseInt(request.getParameter("cantItem"));
    		Item item = (Item) session.getAttribute("itemsel");
    	         
    		if(ctrlItem.validatecantitems(cantItems, item.getcantStock()) && item.getcantStock()>=0)
    		{  
    		
    
    		double calcPrice = (double) ctrlItem.calcPriceItem(item, cantItems);
    		session.setAttribute("cantItems",cantItems);
    		request.setAttribute("calcPrice", calcPrice);
    		request.getRequestDispatcher("/WEB-INF/lib/sellmedicine6.jsp").forward(request, response);
    		}else  {
    			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine5.jsp").forward(request, response);
    			request.setAttribute("errorMessage", "Insuficient Items quantity");
    			
    		}}
	}
}