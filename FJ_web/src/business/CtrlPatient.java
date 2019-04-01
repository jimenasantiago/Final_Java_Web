package business;

import data.PatientCatalog;
import entities.Patient;

public class CtrlPatient {
	public void addPatient (Patient patient){
		
		PatientCatalog cpatient = new PatientCatalog();
	cpatient.addPatient(patient);
	}
	
	public Patient getPatient(int affiliate){
		Patient p = new Patient();
		PatientCatalog pcatalog= new PatientCatalog();
		p=pcatalog.getPatient(affiliate);
		return p;
	}
	
	boolean validatePatient(int affiliate){
		PatientCatalog patientcatalog= new PatientCatalog();
		if (patientcatalog.getPatient(affiliate)!=null){
			return true;
		}else {
			return false;
		}	}
}
