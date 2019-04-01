package business;

import java.util.Date;

import data.HealthPlanCatalog;
import data.PatientCatalog;
import data.PrescriptionCatalog;
import entities.HealthPlan;
import entities.Prescription;

public class CtrlPrescription {
	void countPrescription(int affiliate, int idHealthPlan){
		CtrlPatient ctrlPatient = new CtrlPatient();
		CtrlHPlan ctrlHPlan = new CtrlHPlan();
		if (ctrlPatient.validatePatient(affiliate)==true && ctrlHPlan.validateHealthPlan(idHealthPlan)==true){
			
			PatientCatalog patientcatalog = new PatientCatalog();
		int idPatient =	patientcatalog.getPatient(affiliate).getidPatient();
			
			this.validatecantmaxPrescription(idHealthPlan, idPatient);
		}else {}
		
	}
	
	public int setPrescription(Prescription p){
		
		PrescriptionCatalog pcatalog = new PrescriptionCatalog();
		int idPrescription = pcatalog.addPrescription(p);
		return idPrescription;
	}
	public boolean validatecantmaxPrescription(int idHealthPlan, int idPatient){
		//asks PrescriptionCatalog if the pacient has reached the maximum number of prescriptions per month
		//according to the maximum number of prescriptions allowed (by the HealthPlan)
		//validation required before using this method
		
		HealthPlanCatalog hplancatalog = new HealthPlanCatalog();
		HealthPlan hplan = hplancatalog.getHPbyId(idHealthPlan);
		int cantmaxprescription=hplan.getcantMaxPrescription();
		
		PrescriptionCatalog prescriptioncatalog = new PrescriptionCatalog();
		Date today=new Date();
		
		if (prescriptioncatalog.countPrescriptionsPatient2(idPatient,today)<=cantmaxprescription){
		return true;}
		else {return false;}
			
	}
}
