package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Patient;

public class PatientCatalog {

	public PatientCatalog() {
		// TODO Auto-generated constructor stub
	
	}
   

    public Patient getPatient(int affiliate){
    	//gets a patient by affiliate number
    	Patient p = new Patient();
		String sql="SELECT idpatient, name, affiliateNumberHP, surname, birthdate FROM patient where affiliateNumberHP = ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, affiliate);
			rs= sentencia.executeQuery();
			while (rs !=null && rs.next()){
				p.setidPatient(rs.getInt(1));
				p.setname(rs.getString(2));
				p.setaffiliateNumberHP(rs.getInt(3));
				p.setsurname(rs.getString(4));
				p.setbirthdate(rs.getInt(5));
			
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
		return p;
	}
    	
    
    
    public String addPatient (Patient patient) {
    	ResultSet rs=null;
		PreparedStatement stmt=null;
		String message = "Patient not added";
		int idhealthplanex = patient.getHealthPlanId();
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement("insert into patient (name, surname, affiliateNumberHP, birthdate, idhealthplan) values (?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, patient.getname());
			stmt.setString(2, patient.getsurname());
			stmt.setInt(3, patient.getaffiliateNumberHP());
			stmt.setInt(4, patient.getbirthdate());
			stmt.setInt(5, idhealthplanex);
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				message = "Pacient added";
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


}
