package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Item;
import entities.Prescription_Item;

public class ItemCatalog {

	public ItemCatalog() {
		// TODO Auto-generated constructor stub
	}
	public void addItem (Item item) {

        //TODO: Insert the new item in the DB

       ResultSet rs=null;
              PreparedStatement stmt=null;
              

              try {
                      stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
                    		  "insert into item (idmedicine,idpresentation, cantStock, price, desc) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                      stmt.setInt(1, item.getIdmedicine());
                      stmt.setInt(2, item.getIdpresentation());
                      stmt.setInt(3, item.getcantStock());
                      stmt.setFloat(4, item.getprice());
                      stmt.setString(5, item.getdesc());
                      stmt.execute();

                      rs=stmt.getGeneratedKeys();

                      if(rs!=null && rs.next()){
                              
                      }

              } catch (SQLException e) {
                      // TODO Auto-generated catch block
                      e.printStackTrace();
              }
              finally{

                      try {
                              if(rs!=null ) rs.close();
                              if(stmt != null) stmt.close();
                              
                      } catch (SQLException e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();

                      }

                      FactoryConnection.getInstancia().releaseConn();}}
              

       




	public boolean updateItem(Item item){
	ResultSet rs=null;
	PreparedStatement stmt=null;
	
	boolean answer = true;
	try {
		
		stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
				"UPDATE item SET idmedicine=?, idpresentation=?, price=?, cantStock=? WHERE iditem=?");
		
		stmt.setInt(1, item.getIdmedicine());
		stmt.setInt(2, item.getIdpresentation());
		stmt.setDouble(3, (double)item.getprice());
		stmt.setInt(4,item.getcantStock());
		stmt.setInt(5,item.getidItem());
		
		System.out.println("Item info: id med: " + item.getIdmedicine() + " id pres: " + item.getIdpresentation() + " price: " + item.getprice() + " cant stock: " +item.getcantStock()+ " id item : " + item.getidItem());
		if (item.getidItem()==0){
			answer = false;
		}
		else {
			stmt.executeUpdate();
			System.out.println("Quantity updated!");
			answer = true;}
		
			
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		answer = false;
		e.printStackTrace();
	}
	finally{
		
		try {
			if(rs!=null ) rs.close();
			if(stmt != null) stmt.close();
		} catch (SQLException e) {
			answer = false;
			e.printStackTrace();
		}
		
		FactoryConnection.getInstancia().releaseConn();
	}
	return answer;
	}

    



           

	public ArrayList<Item> getItemsbyMedicine (int idmedicine) {
        //TODO: select from item where idmedicine = idmedicine
        		ResultSet rs=null;
               PreparedStatement stmt=null;
               ArrayList<Item> items = new  ArrayList<Item>();
                       try {
                       stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
                                       "select iditem, idpresentation, idmedicine, price, cantstock, desc from item where idmedicine = ?");
                       stmt.setInt(1, idmedicine);
                       rs = stmt.executeQuery();
                       if(rs !=null && rs.next()){
                               Item i = new Item();
                               i.setidItem(rs.getInt("iditem"));
                               i.setIdpresentation(rs.getInt("idpresentation"));
                               i.setIdmedicine(rs.getInt("idmedicine"));
                               i.setprice(rs.getFloat("price"));
                               i.setcantStock(rs.getInt("cantstock"));
                               i.setDesc(rs.getString("desc"));
                               items.add(i);

                       }
               } catch (SQLException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
               finally
               {
                       try {
                               if(rs!=null)rs.close();
                               if(stmt!=null) stmt.close();
                       } catch (SQLException e) {
                               // TODO Auto-generated catch block
                               e.printStackTrace();
                       }
                       FactoryConnection.getInstancia().releaseConn();
               }
        return items;
    }
	public Item getItem(int idmedicine, int idpresentation) {
		 //TODO: select from item where idmedicine = idmedicine and idpresentation= idpresentation
		ResultSet rs=null;
       PreparedStatement stmt=null;
       Item i= new Item();
               try {
               stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
                               "select iditem, idpresentation, idmedicine, price, cantstock from item where idmedicine = ? and idpresentation = ? ");
               stmt.setInt(1, idmedicine);
               stmt.setInt(2, idpresentation);
               rs = stmt.executeQuery();
               if(rs !=null && rs.next()){
                       
                       i.setidItem(rs.getInt("iditem"));
                       i.setIdpresentation(rs.getInt("idpresentation"));
                       i.setIdmedicine(rs.getInt("idmedicine"));
                       i.setprice(rs.getFloat("price"));
                       i.setcantStock(rs.getInt("cantstock"));
                       

               }
       } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
       }
       finally
       {
               try {
                       if(rs!=null)rs.close();
                       if(stmt!=null) stmt.close();
               } catch (SQLException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
               FactoryConnection.getInstancia().releaseConn();
       }
return i;
	}

	public ArrayList<Item> getItemsbyStock (int cantmin){
		  //TODO: select from item where cantstock <= cantmin
		ResultSet rs=null;
       PreparedStatement stmt=null;
       ArrayList<Item> items = new  ArrayList<Item>();
               try {
               stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
                               "select iditem, idpresentation, idmedicine, price, cantstock, desc from item where cantstock = ? ");
               stmt.setInt(1, cantmin);
               rs = stmt.executeQuery();
               if(rs !=null && rs.next()){
                       Item i = new Item();
                       i.setidItem(rs.getInt("iditem"));
                       i.setIdpresentation(rs.getInt("idpresentation"));
                       i.setIdmedicine(rs.getInt("idmedicine"));
                       i.setprice(rs.getFloat("price"));
                       i.setcantStock(rs.getInt("cantstock"));
                       i.setDesc(rs.getString("desc"));
                       System.out.println("Item id: " + i.getidItem());
                       items.add(i);

               }
       } catch (SQLException e) {
               // TODO Auto-generated catch block
               e.printStackTrace();
       }
       finally
       {
               try {
                       if(rs!=null)rs.close();
                       if(stmt!=null) stmt.close();
               } catch (SQLException e) {
                       // TODO Auto-generated catch block
                       e.printStackTrace();
               }
               FactoryConnection.getInstancia().releaseConn();
       }
return items;
	}
	
	public ArrayList<Item> getItemsbyStock2 (int cantmin){
		ArrayList<Item> items = new ArrayList<Item>();
		ResultSet rs=null;
        PreparedStatement stmt=null;
        
                try {
                stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
                "SELECT * FROM item WHERE cantStock <= ? ");
                stmt.setInt(1, cantmin);
                rs = stmt.executeQuery();
                while(rs !=null && rs.next()){
                	Item i = new Item();    
                	i.setidItem(rs.getInt("iditem"));
                        i.setIdpresentation(rs.getInt("idpresentation"));
                        i.setIdmedicine(rs.getInt("idmedicine"));
                        i.setprice(rs.getFloat("price"));
                        i.setcantStock(rs.getInt("cantStock"));
                        i.setDesc(rs.getString("desc"));
                        System.out.println("Item id: " + i.getidItem());
                        items.add(i);

                }
        } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
        }
        finally
        {
                try {
                        if(rs!=null)rs.close();
                        if(stmt!=null) stmt.close();
                } catch (SQLException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                }
                FactoryConnection.getInstancia().releaseConn();
        }
 return items;
	}
	public Item getItembyId(int idItem) {
		ResultSet rs=null;
	       PreparedStatement stmt=null;
	       Item i= new Item();
	               try {
	               stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
	                               "select * from item where iditem = ? ");
	               stmt.setInt(1, idItem);
	               rs = stmt.executeQuery();
	               if(rs !=null && rs.next()){
	                       
	                       i.setidItem(rs.getInt("iditem"));
	                       i.setIdpresentation(rs.getInt("idpresentation"));
	                       i.setIdmedicine(rs.getInt("idmedicine"));
	                       i.setprice(rs.getFloat("price"));
	                       i.setcantStock(rs.getInt("cantStock"));
	                       i.setDesc(rs.getString("desc"));

	               }
	       } catch (SQLException e) {
	               // TODO Auto-generated catch block
	               e.printStackTrace();
	       }
	       finally
	       {
	               try {
	                       if(rs!=null)rs.close();
	                       if(stmt!=null) stmt.close();
	               } catch (SQLException e) {
	                       // TODO Auto-generated catch block
	                       e.printStackTrace();
	               }
	               FactoryConnection.getInstancia().releaseConn();
	       }
	return i;
		}
}