package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.*;

public class HealthPlanCatalog {
    //TODO: Create the methods to interact whit the DB
   
    public HealthPlan getHPbyId (int idHP){
    	HealthPlan hp = new HealthPlan();
		String sql="select idHealthPlan, nameHP, cantMaxPrescription FROM healthplan where idhealthPlan = ?";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			sentencia.setInt(1, idHP);
			rs= sentencia.executeQuery();
			while (rs !=null && rs.next()){
				hp.setidHealthPlan(rs.getInt(1));
				hp.setnameHP(rs.getString(2));
				hp.setcantMaxPrescription(rs.getInt(3));
			
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
		return hp;
	}
    
    public String addNewHP (HealthPlan newHP) {
        //TODO: Insert into HealthPlan the newHP
        String message = "New Health Plan added";
        ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into healthplan (nameHP, cantMaxPrescription) values (?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newHP.getnameHP());
			stmt.setInt(2, newHP.getcantMaxPrescription());
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
				message = "Health Plan not added";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			}
			
			FactoryConnection.getInstancia().releaseConn();
		}
    	
        return message;
        
    }

    public ArrayList<HealthPlan> getAllHealthPlan () {
        //TODO: return all the health plans to select one
        ArrayList<HealthPlan> hplans = new ArrayList<HealthPlan>();
        
 		
		String sql="SELECT * FROM healthplan";
		PreparedStatement sentencia=null;
		ResultSet rs=null;
		Connection con = FactoryConnection.getInstancia().getConn();
		try 
		{			
			sentencia= con.prepareStatement(sql);
			rs= sentencia.executeQuery();
			while (rs.next()){
				HealthPlan hp = new HealthPlan();
				hp.setidHealthPlan((rs.getInt(1)));
				hp.setnameHP((rs.getString(2)));
				hp.setcantMaxPrescription(rs.getInt(3));
				
				hplans.add(hp);
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
        return hplans;
    }


}