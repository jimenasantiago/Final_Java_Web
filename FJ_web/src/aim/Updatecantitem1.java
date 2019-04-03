package aim;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import business.CtrlItem;
import business.CtrlMedicine;
import entities.Item;
import entities.User;

@WebServlet("/updatecantitem1")
public class Updatecantitem1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Updatecantitem1() {
    	super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/updatecantitem1.jsp").forward(request, response);
		} else {
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		if (loggedUser != null) {
			
			boolean answer;
			String nextPage;
			try {
			CtrlItem ctrlItem = new CtrlItem();
			Item item = new Item();
			int idItem=Integer.parseInt(request.getParameter("idItem"));
			int newItemCant=Integer.parseInt(request.getParameter("newItemCant"));
			
			
			item=ctrlItem.getItembyId(idItem);
			System.out.println("Item stock: " + item.getcantStock());
			item.setcantStock(newItemCant);
			System.out.println("Nueva cant stock: "+ item.getcantStock());
			System.out.println("Item  id y id pres: " + item.getIdmedicine() + item.getIdpresentation());
			answer=ctrlItem.updateAllCantItem(item);
			if (answer){
				nextPage = "menu";
				request.setAttribute("errorMessage", "Quantity updated");
				}
			else{
				nextPage = "updatecantitem1";
				request.setAttribute("errorMessage", "Please insert correct data");}
			//request.setAttribute("infoMessage", "Item updated");	
			
			} catch (NumberFormatException e) {
				nextPage = "updatecantitem1";
				request.setAttribute("errorMessage", "Please insert correct data");
			}
			request.getRequestDispatcher("/WEB-INF/lib/" + nextPage + ".jsp").forward(request, response);
			
		}
	}
}


