package business;

import data.ProfessionalCatalog;
import entities.Professional;

public class CtrlProfessional {

	public Professional getProfessional (int regNumber){
		Professional professional= null;
		ProfessionalCatalog profcatalog = new ProfessionalCatalog();
		professional= profcatalog.getProByRegistNumber(regNumber);
		return professional;
	}
}
