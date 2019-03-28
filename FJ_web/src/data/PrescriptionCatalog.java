package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;

import entities.Prescription;

public class PrescriptionCatalog {

	public PrescriptionCatalog() {
		// TODO Auto-generated constructor stub
	}
	
	public int countPrescriptionsPatient2 (int idpatient, Date date ){
		int prescriptions =0;

		 Calendar calendar = Calendar.getInstance();
	        calendar.setTime(date); 
	        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
	        calendar.add(Calendar.DAY_OF_YEAR, 1);
	        Date lastDayMonth=calendar.getTime(); 
	        
	
	        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
	        Date firstDayMonth=calendar.getTime();
	        
	        java.sql.Date sqlLDM = new java.sql.Date(lastDayMonth.getTime());
	        java.sql.Date sqlFDM = new java.sql.Date(firstDayMonth.getTime());
	        

		String sql="select count(*) from prescription where idpatient = ? and prescriptionDate >= ? or prescriptionDate < ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, idpatient);
			sentencia.setDate(2, sqlFDM);
			sentencia.setDate(3, sqlLDM);
			rs= sentencia.executeQuery();
			while (rs !=null && rs.next()){
				prescriptions=rs.getInt(1);
			
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
		return prescriptions;
	}
    	
	
	public int countPrescriptionsPatient (int idpatient,Date date ){
		int prescriptions =0;
		 ResultSet rs=null;
			PreparedStatement stmt=null;
			// PASAR A METODOS APARTE - OBTENER EL MES!
			
			 Calendar calendar = Calendar.getInstance();
		        calendar.setTime(date); 
		        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMaximum(Calendar.DAY_OF_MONTH)); 
		        calendar.add(Calendar.DAY_OF_YEAR, 1);
		        Date lastDayMonth=calendar.getTime(); 
		        
		
		        calendar.set(Calendar.DAY_OF_YEAR, calendar.getActualMinimum(Calendar.DAY_OF_MONTH)); 
		        Date firstDayMonth=calendar.getTime();
		        
		        java.sql.Date sqlLDM = new java.sql.Date(lastDayMonth.getTime());
		        java.sql.Date sqlFDM = new java.sql.Date(firstDayMonth.getTime());
		        
				try {
				stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
						"select count(*) from prescription where idpatient = ? and prescriptionDate >= ? or prescriptionDate < ?"
		);
				stmt.setInt(1, idpatient);
				stmt.setDate(2, sqlFDM);
				stmt.setDate(3, sqlLDM);
				rs = stmt.executeQuery();
				if(rs !=null && rs.next()){
			    	prescriptions=rs.getInt(1);
			    	
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
		
		return prescriptions;
	}

	public int addPrescription (Prescription prescription) {
        //TODO: Insert the new prescription in the DB

       ResultSet rs=null;
              PreparedStatement stmt=null;
              Integer idPrescription = new Integer(11);
              
      
  	        java.sql.Date sqlDate = new java.sql.Date(prescription.getprescriptionDate().getTime());

              try {
                      stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
                    		  "insert into prescription (prescriptionDate, idpatient, idproffesional,total) values (?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
                      
                      stmt.setDate(1, sqlDate);
                      stmt.setInt(2, prescription.getidpatient());
                      stmt.setInt(3, prescription.getidproffesional());
                      stmt.setDouble(4, prescription.getTotal());
                      stmt.execute();

                      rs=stmt.getGeneratedKeys();

                      if(rs!=null && rs.next()){
                    	  java.math.BigDecimal idColVar = rs.getBigDecimal(1);     
                    	  idPrescription = idColVar.intValueExact();
                    	  System.out.println("Id prescription: " + idPrescription);
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

       

        return idPrescription;
    }



}
