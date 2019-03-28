package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.Prescription_Item;

public class Prescription_ItemCatalog {

	public Prescription_ItemCatalog() {
		// TODO Auto-generated constructor stub
	}
	  public void addPrescriptionItem (Prescription_Item pi) {
	         //TODO: Insert into the DB the new prescription-item
	         ResultSet rs=null;
	                PreparedStatement stmt=null;

	                try {
	                        stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
	                                        "insert into prescription_item (idPrescription, idItem) values  (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
	                        stmt.setInt(1, pi.getidPrescription());
	                        stmt.setInt(2, pi.getidItem());
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

	                        FactoryConnection.getInstancia().releaseConn();
	                }


	     }

	     public void deletePrescription_Item (Prescription_Item pi) {
	         //TODO: Delete from prescription_Item

	         PreparedStatement stmt=null;
	                try {
	                        stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
	                                        "DELETE from prescription_item where idprescription = ? and iditem= ?"
	                                        );
	                        stmt.setInt(1, pi.getidPrescription());
	                         stmt.setInt(2, pi.getidItem());
	                        stmt.execute();

	                } catch (SQLException e) {
	                        // TODO Auto-generated catch block
	                        e.printStackTrace();
	                }
	                finally
	                {
	                        try {
	                                if(stmt!=null) stmt.close();

	                        } catch (SQLException e) {
	                                // TODO Auto-generated catch block
	                                e.printStackTrace();

	                        }
	                        FactoryConnection.getInstancia().releaseConn();



	        }



	                }

	public ArrayList<Prescription_Item> getItemsbyPrescription (int idPrescription) {
	         //TODO: select from prescription_item
	         		ResultSet rs=null;
	                PreparedStatement stmt=null;
	                ArrayList<Prescription_Item> pitems = new  ArrayList<Prescription_Item>();
	                        try {
	                        stmt =   FactoryConnection.getInstancia().getConn().prepareStatement(
	                                        "select idprescription, iditem from prescription_item where idprescription = ?");
	                        stmt.setInt(1, idPrescription);
	                        rs = stmt.executeQuery();
	                        if(rs !=null && rs.next()){
	                                Prescription_Item pi = new Prescription_Item();
	                                pi.setidPrescription(rs.getInt("idprescription"));
	                                //pi.setidItem(rs.getInt("iditem"));
	                                pitems.add(pi);

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
	         return pitems;
	     }
}
