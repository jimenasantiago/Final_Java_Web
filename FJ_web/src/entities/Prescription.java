package entities;

import java.util.Date;

public class Prescription {
	
	int idPrescription;
	Date prescriptionDate;
	int idpatient;
	int idproffesional;
	int idItem;
	double total;
	
	//set
	public void setidprescription (int id) {
		this.idPrescription = id;
	}
	
	public void setprescriptionDate (Date prescdate) {
		this.prescriptionDate = prescdate;
	}
	
	public void setidpatient (int id) {
		this.idpatient = id;
	}
	
	public void setidproffesional (int id) {
		this.idproffesional = id;
	}
	
	public void setidItem (int id) {
		this.idItem = id;
	}
	
	public void setTotal (double total) {
		this.total = total;
	}
	
	//get
	public int getidPrescription () {
		return idPrescription;
	}
	
	public Date getprescriptionDate () {
		return prescriptionDate;
	}
	
	public int getidpatient () {
		return idpatient;
	}
	
	public int getidproffesional () {
		return idproffesional;
	}
	
	public int getidItem () {
		return idItem;
	}
	
	public double getTotal () {
		return total;
	}
}
