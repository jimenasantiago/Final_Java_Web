package business;

import java.util.ArrayList;

import data.GenericDrugCatalog;
import entities.GenericDrug;

public class CtrlGDrug {
	public ArrayList<GenericDrug> getAllGenericDrug (){
		//gets all generic drugs 
		ArrayList<GenericDrug> gdrugs = new ArrayList<GenericDrug>();
		GenericDrugCatalog gdrugcatalog = new GenericDrugCatalog();
		gdrugs=gdrugcatalog.getgenericDrugs();
		return gdrugs;
	}
	
	public GenericDrug getGenericDrug (String gdrug){
		//gets a generic drug giving the name
			
			GenericDrug genericdrug = new GenericDrug();
			GenericDrugCatalog gdrugcatalog = new GenericDrugCatalog();
			genericdrug= gdrugcatalog.getGenericDrug(gdrug);
			
			
			return genericdrug;
		}
}
