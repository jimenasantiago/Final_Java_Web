package entities;

public class HealthPlan {
	
	int cantMaxPrescription;
	int idHealthPlan;
	String nameHP;
	
	//set
	public void setcantMaxPrescription (int cantMax) {
		this.cantMaxPrescription = cantMax;
	}
	
	public void setidHealthPlan (int id) {
		this.idHealthPlan = id;
	}
	
	public void setnameHP (String name) {
		this.nameHP = name;
	}
	
	//get
	public int getcantMaxPrescription () {
		return cantMaxPrescription;
	}
	
	public int getidHealthPlan () {
		return idHealthPlan;
	}
	
	public String getnameHP () {
		return nameHP;
	}
}
