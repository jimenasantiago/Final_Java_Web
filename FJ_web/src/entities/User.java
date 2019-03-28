package entities;

public class User {

	int dni;
	String email;
	String surname;
	String name;
	String type;
	int idUser;		
	String password;
	
	public User(){	
		
	}
        
	public User(int dni, String name, String surname){
		setDni(dni);
		setName(name);
		setSurname(surname);
	}
	
	//set
	public void setDni (int dni) {
		this.dni = dni;
	}

	public void setEmail (String email) {
		this.email = email;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setSurname (String surname) {
		this.surname = surname;
	}
	
	public void setPassword (String password) {
		this.password = password;
	}
	
	public void setidUser (int id) {
		this.idUser = id;
	}
	
	public void setType (String type) {
		this.type = type;
	}
	
	//get
	public int getDni () {
		return dni;
	}
		
	public String getEmail () {
		return email;
	}
	
	public String getName () {
		return name;
	}
	
	public String getSurname () {
		return surname;
	}
	
	public String getPassword () {
		return password;
	}

	public int getidUser () {
		return idUser;
	}
	
	public String getType () {
		return type;
	}
}
