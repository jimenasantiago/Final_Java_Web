package business;

import data.Prescription_ItemCatalog;
import entities.Prescription_Item;

public class CtrlPres_Item {
	public void setPrescription_Item(Prescription_Item pi){
		Prescription_ItemCatalog picatalog = new Prescription_ItemCatalog();
		picatalog.addPrescriptionItem(pi);
	}
}
