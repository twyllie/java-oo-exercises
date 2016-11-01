package blogz;

import java.util.regex.Pattern;
import java.util.ArrayList;

public class User {
	
	private String username;
	private String password;
	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	public User(String username, String plainPassword){
		this.password = hashPassword(plainPassword);
		this.username = username;
		allUsers.add(this);
	}
	
	private static String hashPassword(String plainPass){
		return plainPass;
	}
	
	private static ArrayList getUsers(){
		return allUsers;
	}
	
	private boolean isValidPassword(String password){
		if (password.equals(this.password)){
			return true;
		}
		else{
			return false;
		}
	}
	
	private boolean isValidUsername(String username){
		boolean matches = Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
		if (matches){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
