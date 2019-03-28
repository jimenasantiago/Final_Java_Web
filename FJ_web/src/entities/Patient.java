package entities;

public class Patient {
	
	int idPatient;
	String surname;
	String name;
	int birthdate;
    int idHP;
	int affiliateNumberHP;
	
	//set
	public void setidPatient (int id) {
		this.idPatient = id;
	}
	
	public void setsurname (String surname) {
		this.surname = surname;
	}
	
	public void setname (String name) {
		this.name = name;
	}
	
	public void setbirthdate (int birthdate) {
		this.birthdate = birthdate;
	}
	
	public void setaffiliateNumberHP (int number) {
		this.affiliateNumberHP = number;
	}
	

	public int getidPatient () {
		return idPatient;
	}
	
	public String getsurname () {
		return surname;
	}
	
	public String getname () {
		return name;
	}
	
	public int getbirthdate () {
		return birthdate;
	}
	
	public int getHealthPlanId () {
		return idHP;
	}
	
	public int getaffiliateNumberHP () {
		return affiliateNumberHP;
	}

	public void setHealthPlanId(int idHP) {
		this.idHP = idHP;
		
	}
}
