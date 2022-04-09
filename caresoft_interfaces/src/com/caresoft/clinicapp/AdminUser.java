package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class AdminUser extends User
{
//... imports class definition...
    
    // Inside class:
    private Integer employeeID;
    private String role;
    private ArrayList<String> securityIncidents;
//	private String id;
	private int pin;
    
    // TO DO: Implement a constructor that takes an ID and a role
    // TO DO: Implement HIPAACompliantUser!
    // TO DO: Implement HIPAACompliantAdmin!
    
    public AdminUser(Integer id, String role) 
    {
		// TODO Auto-generated constructor stub
    	super(id);
    	this.role = role;
    	securityIncidents = new ArrayList<String>();
	}
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
    public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
    
    
    // -------- TO DO: Setters & Getters --------
	public Integer getEmployeeID() 
	{
		return employeeID;
	}
	
	public void setEmployeeID(Integer employeeID) 
	{
		this.employeeID = employeeID;
	}
	
	public String getRole() 
	{
		return role;
	}
	
	public void setRole(String role) 
	{
		this.role = role;
	}
	
	public boolean assignPin(int pin) 
	{
		// TODO Auto-generated method stub
		if(pin <= 100000) {
			System.out.println("Pin Needs to be 4 Digits");
			return false;
		}
		this.pin = pin;
		return true;
	}
	
	
	public boolean accessAuthorized(Integer confirmedAuthID) 
	{
		// TODO Auto-generated method stub
		if(this.pin == confirmedAuthID) {
			return true;	
		}
		authIncident();
		return false;
	}
	
	public ArrayList<String> reportSecurityIncidents() 
	{
		// TODO Auto-generated method stub
		return securityIncidents;
	}

}
