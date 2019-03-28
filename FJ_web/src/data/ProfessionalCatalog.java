package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import data.FactoryConnection;
import entities.*;

public class ProfessionalCatalog {
    //TODO: create the methods to interact with the DB
    public Professional getProByRegistNumber (int number) {
        //TODO: select from professional where registrationNumber === number
        Professional pro = new Professional(); 
       
        ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"select idprofessional, name, surname, registrationNumber from professional where registrationNumber = ?"
					);
			stmt.setInt(1, number);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	pro.setidProffesional(rs.getInt("idprofessional"));
				pro.setname(rs.getString("name"));
				pro.setsurname(rs.getString("surname"));
				pro.setregistrationNumber(rs.getInt("registrationNumber"));
				
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
        return pro;
    }

    public String addNewProfessional (Professional pro) {
        //TODO: Insert into the DB the new pro
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		String message = "Professional not added";
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into proffesional (name, surname, registrationNumber) values (?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, pro.getname());
			stmt.setString(2, pro.getsurname());
			stmt.setInt(3, pro.getregistrationNumber());
					
			stmt.execute();

			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				message = "Professional added";
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
    	
        return message;
    }

    public String deleteProfessional (int number) {
        //TODO: Delete from professional where registrationNumber === number
    	String message = "Professional not deleted";
    	PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"DELETE from proffesional where registrationNumber = ?"
					);
			stmt.setInt(1, number);
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null) stmt.close();
				 message = "Professional deleted";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			FactoryConnection.getInstancia().releaseConn();
		
	
	
	}
    	

		
		return message;
    }
}