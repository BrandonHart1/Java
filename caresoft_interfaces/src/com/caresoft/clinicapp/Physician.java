package com.caresoft.clinicapp;

import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser 
{
//... imports class definition...
    
    // Inside class:    
    private ArrayList<String> patientNotes;
	private String id;
	
    // TO DO: Constructor that takes an ID
    // TO DO: Implement HIPAACompliantUser!
	
    public Physician(int i) {
		// TODO Auto-generated constructor stub
    	super(i);
	}

	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public boolean assignPin(int pin) 
	{
		// TODO Auto-generated method stub
		if(pin <= 1000 && pin >= 9999) {
			System.out.println("Pin Must Be At Least 4 Digits");
			return false;
		}
		this.pin = pin;
		return true;
	}

	public boolean accessAuthorized(int i) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) 
	{
		if(this.pin == confirmedAuthID) {
			return true;
		}
		// TODO Auto-generated method stub
		return false;
	}
	
    // TO DO: Setters & Getters

}
