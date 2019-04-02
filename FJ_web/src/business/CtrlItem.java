package business;

import java.util.ArrayList;

import data.ItemCatalog;
import entities.Item;

public class CtrlItem {

	public Item getItem (int idmedicine, int idpresentation){
		Item item = new Item();
		ItemCatalog icatalog = new ItemCatalog();
		item = icatalog.getItem(idmedicine, idpresentation);
		return item;
	}
	
	public void updateCantItem (Item item, int cant){
		//sets the new cant of the item and updates in the DB
		ItemCatalog icatalog = new ItemCatalog();
		int newCant = item.getcantStock()-cant;
		item.setcantStock(newCant);
		icatalog.updateItem(item);
	}
	public boolean updateAllCantItem (Item item){
		//sets the new cant of the item and updates in the DB
		boolean answer;
		ItemCatalog icatalog = new ItemCatalog();
		answer=icatalog.updateItem(item);
		return answer;
	}
	
	public boolean validatecantitems(int cantSelected, int cantItems){
		if(cantItems>0 && cantSelected<=cantItems && cantSelected>0)
		{return true;}
		else {return false;}	
	}
	
	public double calcPriceItem (Item item, int cant){
		double priceItem;
		System.out.println("price item: "+ item.getprice());
		System.out.println("cant: "+ cant);
		priceItem=(double)cant*(double)item.getprice();
		System.out.println("Sale price: "+ priceItem);
		return priceItem;
	}

	public void updateItem(int idMedicine, int idPresentation, double percent) {
		ItemCatalog icatalog = new ItemCatalog();
		Item item = new Item();
		item=this.getItem(idMedicine, idPresentation);
		double newPrice=item.getprice()*(float)(1+percent);
		item.setprice((float) newPrice);
		icatalog.updateItem(item);
		
	}
	public ArrayList<Item> getItemsbyStock (int cantmin){
		ArrayList<Item> itemsMin = new ArrayList<Item>();
		ItemCatalog icatalog = new ItemCatalog();
		itemsMin=icatalog.getItemsbyStock2(cantmin);
		for(int i=0;i<itemsMin.size();i++)
   {System.out.println("Item id medicine: " + itemsMin.get(i).getIdmedicine());}
		return itemsMin;
	}

	public Item getItembyId(int idItem) {
		ItemCatalog icatalog = new ItemCatalog();
		Item item=icatalog.getItembyId(idItem);
		return item;
	}
	
}
