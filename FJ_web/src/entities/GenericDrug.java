package entities;

public class GenericDrug {

	int idDrug;
	String drugName;
	
	//set
	public void setidDrug (int Id) {
		this.idDrug = Id;
	}
	
	public void setdrugName (String name) {
		this.drugName = name;
	}
	
	//get
	public int getidDrug() {
		return idDrug;
	}
	
	public String getdrugName () {
		return drugName;
	}
	
}
