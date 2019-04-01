package business;

import java.util.ArrayList;

import data.PresentationCatalog;
import entities.Presentation;

public class CtrlPresentation {

	public ArrayList<Presentation> getPresentationByMedicine (int idmedicine){

		ArrayList<Presentation> presentations = new ArrayList<Presentation>();
		PresentationCatalog pcatalog = new PresentationCatalog();
		presentations=pcatalog.getPresentationByMedicine(idmedicine);
		
		return presentations;
	}
	
}
