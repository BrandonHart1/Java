package com.caresoft.clinicapp;

public interface HIPAACompliantUser 
{
	abstract boolean assignPin(int pin);  // method that list the requirements
	abstract boolean accessAuthorized(Integer confirmedAuthID); // method that lists the requirements
}
