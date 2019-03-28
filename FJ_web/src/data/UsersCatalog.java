package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.*;

public class UsersCatalog {
	//TODO: create the method to conect with the DB
	public User getUser (int dni, String pass) {
		//TODO: get the user by id and pass
		User finduser = new User();
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
			try {
			stmt =FactoryConnection.getInstancia().getConn().prepareStatement("select dni, name, surname, email, type, password, iduser from user where dni = ? and password = ?");
			stmt.setInt(1, dni);
			stmt.setString(2, pass);
			rs = stmt.executeQuery();
			if(rs !=null && rs.next()){
		    	finduser.setDni(rs.getInt("dni"));
				finduser.setName(rs.getString("name"));
				finduser.setSurname(rs.getString("surname"));
				finduser.setEmail(rs.getString("email"));
				finduser.setType(rs.getString("type"));
				finduser.setPassword(rs.getString("password"));
				finduser.setidUser(rs.getInt("iduser"));
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
		
			return finduser;
	}

	public String addUser (User newUser) {
		//TODO: Insert newuser in the DB and get the new ID
		ResultSet rs=null;
		PreparedStatement stmt=null;
		String message = "User not added";
		
		try {
			stmt = FactoryConnection.getInstancia().getConn().prepareStatement(
					"insert into user (name, surname, dni, email, password, type) values (?,?,?,?,?,?)",PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, newUser.getName());
			stmt.setString(2, newUser.getSurname());
			stmt.setInt(3, newUser.getDni());
			stmt.setString(4, newUser.getEmail());
			stmt.setString(5, newUser.getPassword());
			stmt.setString(6, newUser.getType());
			stmt.execute();
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				message = "User added";
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

	public String deleteUser (int id) {
		//TODO: find the user by ID and delete it
		String message = "User not found";
		
    	PreparedStatement stmt=null;
		try {
			stmt = 	FactoryConnection.getInstancia().getConn().prepareStatement(
					"DELETE from user where idUser = ?"
					);
			stmt.setInt(1, id);
			stmt.execute();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				if(stmt!=null) stmt.close();
				 message = "User deleted";
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();	
			}
			FactoryConnection.getInstancia().releaseConn();
	}
		return message;
		
	}
}
