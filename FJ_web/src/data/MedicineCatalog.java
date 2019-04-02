package data;

import java.sql.*;
import java.util.ArrayList;

import entities.*;

public class MedicineCatalog {
	public ArrayList<Medicine> getMedicines () {
        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
		String sql="SELECT * FROM medicine";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		
		try {			
			sentencia= con.prepareStatement(sql);
			rs= sentencia.executeQuery();
			while (rs.next()) {
				Medicine medicine = new Medicine();
				medicine.setdescription(rs.getString("description"));
				medicine.setname(rs.getString("name"));
				medicine.setidMedicine(rs.getInt("idmedicine"));
				
				GenericDrug genericDrug =new GenericDrug();
				genericDrug.setidDrug((rs.getInt("iddrug")));
				medicine.setgenericDrugs(genericDrug);
				
				medicines.add(medicine);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs!=null) {
					rs.close();
				}
				if (sentencia!=null && !sentencia.isClosed()) {
					sentencia.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
		return medicines;
    }
	
    //TODO:Create the methods to interact whit the DB
    public Medicine getMedicine (String name) {
        //TODO: select from medicine where medicineName === name
        Medicine medicine = new Medicine();
        

        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select description, name, iddrug, idmedicine from medicine where name = ?"
					);
			stmt.setString(1, name);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	medicine.setdescription(rs.getString("description"));
				medicine.setname(rs.getString("name"));
				medicine.setidMedicine(rs.getInt("idmedicine"));
				
				GenericDrug genericDrug =new GenericDrug();
				genericDrug.setidDrug((rs.getInt("iddrug")));
				medicine.setgenericDrugs(genericDrug);
				
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
        
        return medicine;
    } 

    public String addMedicine (Medicine medicine) {
        //TODO: Insert the new medicine in the DB
    	String message = "";
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement("insert into medicine (name, description, iddrug) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, medicine.getname());
			stmt.setString(2, medicine.getdescription());
			stmt.setInt(3, medicine.getgeneric().getidDrug());
					
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				message = "New medicine added";
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				message = "New medicine not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				message = "Professional not added";
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
    	message = "New medicine added";

        return message;
    }

    public void addMedicine2 (Medicine m){
    	  FactoryConnection fc = new FactoryConnection();

          // Pasamos el objeto Connection de nuestra clase "ConexionBD" a esta instancia por medio del m�todo getConnection()
          Connection con = fc.getConn();

          // Crear sentencia SQL para insertar en la base de datos
          String query = "INSERT INTO medicine (name, description, generic) values (?, ?, ?)";

          try {
              Statement st = con.createStatement();
              ResultSet rs = st.executeQuery(query);

              rs.updateString(1, m.getname());
  			rs.updateString(2, m.getdescription());
  			((PreparedStatement) rs).setInt(3, m.getgeneric().getidDrug());

              // Indicamos que comience la actualizaci�n de la tabla en nuestra base de datos
              st.executeUpdate(query);

              // Cerramos las conexiones, en orden inverso a su apertura
              st.close();
              con.close();

              System.out.println("Llamada agregada con �xito a la base de datos.");
          } catch (SQLException e) {
              System.out.println("Error!, la llamada no pudo ser agregada a la base de datos.");
          }
    }
    public ArrayList<Medicine> getMedicineWithSameGeneric (int generic) {
        //TODO: Think a little more about this method, the idea is get all the medicine whit that generic
        ArrayList<Medicine> medicines = new ArrayList<Medicine>();
        
        
        String sql="SELECT idmedicine, description, iddrug, name FROM medicine WHERE iddrug = ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, generic );
			rs= sentencia.executeQuery();
			
			while (rs !=null && rs.next()){
				Medicine medicine = new Medicine();
				medicine.setidMedicine(rs.getInt(1));
				medicine.setdescription(rs.getString(2));
				medicine.setname(rs.getString(4));
				System.out.println(medicine.getname());
				GenericDrug drug = new GenericDrug();
				drug.setidDrug(rs.getInt(3));
				medicine.setgenericDrugs(drug);
				medicines.add(medicine);
			}
			
				
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if(rs!=null)
				{
					rs.close();
				}
				if(sentencia!=null && !sentencia.isClosed())
				{
					sentencia.close();
				}
				FactoryConnection.getInstancia().releaseConn();
			}
			catch (SQLException sqle)
			{
				sqle.printStackTrace();
			}
		}
        
        return medicines;
    }

	public void updateMedicine(double percent) {
		

		
	}
	public Medicine getMedicinebyId (int idmedicine) {
        //TODO: select from medicine where idmedicine = idmedicine
        Medicine medicine = new Medicine();
        

        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select description, name, iddrug, idmedicine from medicine where idmedicine = ?"
					);
			stmt.setInt(1, idmedicine);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	medicine.setdescription(rs.getString("description"));
				medicine.setname(rs.getString("name"));
				medicine.setidMedicine(rs.getInt("idmedicine"));
				
				GenericDrug genericDrug =new GenericDrug();
				genericDrug.setidDrug((rs.getInt("iddrug")));
				medicine.setgenericDrugs(genericDrug);
				
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
        
        return medicine;
    } 
}