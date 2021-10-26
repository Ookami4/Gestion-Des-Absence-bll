package com.ensah.core.bo;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Timetable { 

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int idTimetable;

   private String data;

	public int getIdTimetable() {
		return idTimetable;
	}
	
	public void setIdTimetable(int idTimetable) {
		this.idTimetable = idTimetable;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}

   

}