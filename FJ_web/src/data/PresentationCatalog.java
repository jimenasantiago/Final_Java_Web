package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entities.*;

public class PresentationCatalog {

	public PresentationCatalog() {
		// TODO Auto-generated constructor stub
	}
		
		public ArrayList<Presentation> getPresentationByMedicine (int idmedicine){
			 //TODO: Think a little more about this method, the idea is get all presentation with the same idmedicine
	        ArrayList<Presentation> presentations = new ArrayList<Presentation>();

	        String sql="SELECT presentation.idpresentation, presentation.description FROM presentation INNER JOIN item on item.idpresentation = presentation.idpresentation where item.idmedicine = ?";
			PreparedStatement sentencia=null;
			ResultSet rs=null;

			Connection con = FactoryConnection.getInstancia().getConn();
			try 
			{			
				sentencia= con.prepareStatement(sql);
				sentencia.setInt(1, idmedicine );
				rs= sentencia.executeQuery();
				
				while (rs !=null && rs.next()){
					Presentation p = new Presentation();
					p.setIdPresentation(rs.getInt("presentation.idpresentation"));
					p.setDescription(rs.getString("presentation.description"));
					System.out.println(p.getDescription());
					presentations.add(p);
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
	        
	        return presentations;
			
			
			
		}
	

}
