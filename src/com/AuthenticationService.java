package com;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.Buyer;
import model.FundRiser;
import model.Login;
import model.Researcher;

@Path("/Athentication")
public class AuthenticationService {
	
	Login login = new Login();
	Researcher researcher = new Researcher();
	Buyer buyer = new Buyer();
	FundRiser fundRiser = new FundRiser();
	
	// Main Authentication Check Service
	@POST
	@Path("/Login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String checkLogin(@FormParam("username") String uName, @FormParam("password") String pswd) {
		String output = login.loginProcess(uName,pswd);
		return output;
	}
	
}
