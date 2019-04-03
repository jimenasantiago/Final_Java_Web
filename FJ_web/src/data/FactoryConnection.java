package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class FactoryConnection {


	private String dbDriver="com.mysql.jdbc.Driver";

	//private String host="localhost";
	private String host="node30541-java19.jelastic.saveincloud.net";
	private String port="3306";
	private String user="root";
	//private String pass="root";
	private String pass="BANdae53977";
	private String db="pharmacy";
	
	private Connection conn;
	private int cantCon;
	
	FactoryConnection(){
		try {
			Class.forName(dbDriver);
			conn=null;
			cantCon=0;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private static FactoryConnection instancia;
	
	public static FactoryConnection getInstancia(){
		if (instancia==null){
			instancia = new FactoryConnection();
		}
		return instancia;
	}
	
	
	
	public Connection getConn(){
		try {
			if(conn==null || conn.isClosed()){
				conn = DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+db+"?user="+user+"&password="+pass);
				cantCon++;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public void releaseConn(){
		try {
			cantCon--;
			if(cantCon==0){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

