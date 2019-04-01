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

@WebServlet("/sellmedicine4")
public class Sellmedicine4 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Sellmedicine4() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		
		if (loggedUser != null) {
			request.getRequestDispatcher("/WEB-INF/lib/sellmedicine4.jsp").forward(request, response);}
		 
		else {request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		User loggedUser = session != null ? (User) session.getAttribute("userSession") : null;
		Professional prof = new Professional();
	
		ArrayList<Presentation> lista = new ArrayList<Presentation>();
		lista = (ArrayList<Presentation>) request.getAttribute("pres");
		

		if (loggedUser != null) {
			try{
			CtrlItem ctrlItem = new CtrlItem();
			CtrlProfessional ctrlProfessional = new CtrlProfessional();
			Medicine medicine = (Medicine) session.getAttribute("medicine");
			Item item = new Item();
			item = ctrlItem.getItem(medicine.getidMedicine(), Integer.parseInt(request.getParameter("idPresentation")));
			
			
			prof = ctrlProfessional.getProfessional(Integer.parseInt(request.getParameter("regNumberP")));
			System.out.println("Proffesional name: " + prof.getname());
			session.setAttribute("professional", prof);
			session.setAttribute("itemsel", item);
			request.setAttribute("item", item);
			
			      if(prof.getidProffesional()==0) 
			 
				  {
			    	  
			    	  
			    	  request.setAttribute("errorMessage", "Proffesional incorrect");
				  request.getRequestDispatcher("/WEB-INF/lib/sellmedicine2.jsp").forward(request, response);
			         
				       }else	  {request.getRequestDispatcher("/WEB-INF/lib/sellmedicine5.jsp").forward(request, response);}		
				   
				// else{request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);}
				  
		
			
			
		
		}
			
			catch (NumberFormatException e) {
				request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
				request.setAttribute("errorMessage", "");
			}
			request.getRequestDispatcher("/WEB-INF/lib/login.jsp").forward(request, response);
}}}
	
	
