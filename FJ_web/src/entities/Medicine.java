package entities;

public class Medicine {
	
	int idMedicine;
	String description;
	String name;
	GenericDrug generic = null;
	
	//set
	public void setidMedicine (int id) {
		this.idMedicine = id;
	}

	public void setdescription (String desc) {
		this.description = desc;
	}
	
	public void setname (String name) {
		this.name = name;
	}

	public void setgenericDrugs (GenericDrug drug) {
		this.generic=drug; 
	}
	
	//get
	
	public int getidMedicine () {
		return idMedicine;
	}
	
	public String getdescription () {
		return description;
	}
	
	public String getname () {
		return name;
	}

	public GenericDrug getgeneric () {
		return generic;
	}
}
