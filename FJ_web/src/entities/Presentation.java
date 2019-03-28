package entities;

public class Presentation {
	
	int idPresentation;
	String description;
	
	//set
	public void setIdPresentation (int idpresentation) {
		this.idPresentation = idpresentation;
	}
	
	public void setDescription (String description) {
		this.description = description;
	}
	
	
	
	public int getIdPresentation () {
		return idPresentation;
	}
	
	public String getDescription () {
		return description;
	}
}
