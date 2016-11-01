package blogz;

import java.util.regex.Pattern;
import java.util.ArrayList;

public class User extends Entity{
	
	private String username;
	private String password;
	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	public User(String username, String plainPassword){
		super();
		this.password = hashPassword(plainPassword);
		this.username = username;
		allUsers.add(this);
	}
	
	private static String hashPassword(String plainPass){
		return plainPass;
	}


	private static boolean isValidUsername(String username){
		boolean matches = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
		if (matches){
			return true;
		}
		else{
			return false;
		}
	}
	
	public static ArrayList getUsers(){
		return allUsers;
	}

	public String getUsername(){
		return this.username;
	}
	
	private boolean isValidPassword(String password){
		if (password.equals(this.password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
