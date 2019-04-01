package business;

import data.UsersCatalog;
import entities.User;

public class CtrlUser {

	public User getUser (int dni, String pass) {
		UsersCatalog usersCatalog = new UsersCatalog();
		return usersCatalog.getUser(dni, pass);
	}
	
	public boolean validateUser (int dni, String pass){
		//asks UserCatalog if the dni number belongs to a registered user
		User us = new User();
		UsersCatalog user= new UsersCatalog();
		us=user.getUser(dni, pass);
		System.out.println("User: " + us.getDni() + "Pass: " + us.getPassword()) ;
		System.out.println("User type: " + us.getType() ) ;
		if ( us.getDni()==dni){
			System.out.println("Se encontr� el usuario!");
			return true;
		}else {
			System.out.println("No se encontr� el usuario!");
			return false;
		}
	}
}
