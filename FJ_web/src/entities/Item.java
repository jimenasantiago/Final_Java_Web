package entities;

public class Item {
	
	int idItem, idmedicine, idpresentation;
	int cantStock;
	float price;
	
	//set
	public void setidItem (int id) {
		this.idItem = id;
	}
	
	public void setcantStock (int cant) {
		this.cantStock = cant;
	}
	
	public void setprice (float price) {
		this.price = price;
	}
	
	//get
	public int getidItem () {
		return idItem;
	}
	
	public int getcantStock () {
		return cantStock;
	}
	
	public float getprice () {
		return price;
	}

	
	public int getIdmedicine() {
		return idmedicine;
	}

	public void setIdmedicine(int idmedicine) {
		this.idmedicine = idmedicine;
	}

	public int getIdpresentation() {
		return idpresentation;
	}

	public void setIdpresentation(int idepresentation) {
		this.idpresentation = idepresentation;
	}
}
