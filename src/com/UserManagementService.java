package com;

import model.Users;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Users")
public class UserManagementService {
	Users userObject = new Users();
	
	// Read Users List
	@GET
	@Path("/UserList")
	@Produces(MediaType.TEXT_HTML)
	public String readUsers() {
		return userObject.readUsers();
	}
	
	// Insert New User
	@POST
	@Path("/AddUser")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String insertUser(@FormParam("first_name") String fName, @FormParam("last_name") String lName, @FormParam("date_of_birth") String dob, @FormParam("address") String address,
			@FormParam("telephone_no") String tNo, @FormParam("username") String uName, @FormParam("password") String pwd, @FormParam("email") String email, @FormParam("user_type") String uType) {
		String Output = userObject.insertUser(fName, lName, dob, address, tNo, uName, pwd, email, uType);
		return Output;
	}
	
	// Update User
	@PUT
	@Path("/UpdateUser")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updateUser(String userData) {
		//Convert the input string to a JSON object 
		JsonObject userJsonObject = new JsonParser().parse(userData).getAsJsonObject();
		 
		//Read the values from the JSON object
		String id = userJsonObject.get("id").getAsString(); 
		String fName = userJsonObject.get("first_name").getAsString(); 
		String lName = userJsonObject.get("last_name").getAsString(); 
		String dob = userJsonObject.get("date_of_birth").getAsString(); 
		String address = userJsonObject.get("address").getAsString(); 
		String tNo = userJsonObject.get("telephone_no").getAsString();
		String uName = userJsonObject.get("username").getAsString();
		String pwd = userJsonObject.get("password").getAsString();
		String email = userJsonObject.get("email").getAsString();
		String uType = userJsonObject.get("user_type").getAsString();
		
		String output = userObject.updateUser(id, fName, lName, dob, address, tNo, uName, pwd, email, uType);
		
		return output;
	}
	
	// Delete User
	@DELETE
	@Path("/DeleteUser")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteItem(String userData) {
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(userData, "", Parser.xmlParser()); 
		 
		//Read the value from the element <itemID>
		String id = doc.select("id").text(); 
		String output = userObject.deleteUser(id); 
		return output;
	}
}
