package entities;

public class Professional {
	
	int idProffesional;
	int registrationNumber;
	String surname;
	String name;
	
	//set
	public void setidProffesional (int id) {
		this.idProffesional = id;
	}
	
	public void setregistrationNumber (int number) {
		this.registrationNumber = number;
	}
	
	public void setsurname (String surname) {
		this.surname = surname;
	}
	
	public void setname (String name) {
		this.name = name;
	}
	
	//get
	public int getidProffesional () {
		return idProffesional;
	}
	
	public int getregistrationNumber () {
		return registrationNumber;
	}
	
	public String getsurname () {
		return surname;
	}
	
	public String getname () {
		return name;
	}
}
