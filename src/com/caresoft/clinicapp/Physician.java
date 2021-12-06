package com.caresoft.clinicapp;

import java.sql.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser{
	
	
	
	boolean assignPin = false;
	boolean accessAuthorized = false;
	private ArrayList<String> patientNotes;
	private Integer id;
	
	public Physician(Integer id) {
		this.id = id;
	}
		
    public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }



	@Override
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if(length < 4) {
			return false;
		}else {
			return true;
		}
		
	}



	@Override
	public boolean accessAuthorized(Integer confirmedAuthID) {
		return true;
	}
    
}
