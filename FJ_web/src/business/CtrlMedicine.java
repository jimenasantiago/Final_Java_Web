package business;

import java.util.ArrayList;

import data.MedicineCatalog;
import entities.Item;
import entities.Medicine;
import entities.Presentation;

public class CtrlMedicine {

	
	public void addMedicine(Medicine medicine) {
		MedicineCatalog cmedicine = new MedicineCatalog();
		cmedicine.addMedicine(medicine);
		
	}
	
	public ArrayList<Medicine> getMedicineByDrug (int idgdrug){
		// returns all the medicine with the same generic drug
		
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
		MedicineCatalog mcatalog = new MedicineCatalog();
		medicines=mcatalog.getMedicineWithSameGeneric(idgdrug);
		
		return medicines;
	}
	
	public Medicine getMedicineByName(String medicineName){
		Medicine medicine = new Medicine();
		MedicineCatalog mcatalog = new MedicineCatalog();
		medicine=mcatalog.getMedicine(medicineName);
		return medicine;
	}
	
	public ArrayList<Medicine> getMedicines (){
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
		MedicineCatalog medicineCatalog = new MedicineCatalog();
		medicines = medicineCatalog.getMedicines();
		return medicines;
	}
	
	public void updatePriceMedicines (double percent){
		ArrayList<Medicine> medicines = new ArrayList<Medicine>();
		
		medicines=this.getMedicines();
		for(int m=0;m<medicines.size();m++){
			CtrlPresentation ctrlPresentation = new CtrlPresentation();
			ArrayList<Presentation> pres = new ArrayList<Presentation>();
			pres=ctrlPresentation.getPresentationByMedicine(medicines.get(m).getidMedicine());
			   for(int p=0;p<pres.size();p++)
			{CtrlItem ctrlItem = new CtrlItem();
			
			ctrlItem.updateItem(medicines.get(m).getidMedicine(), pres.get(p).getIdPresentation(),percent);
			
			
			}
			
		}
		}
	}

