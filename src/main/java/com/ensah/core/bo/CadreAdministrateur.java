package com.ensah.core.bo;


import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name="idCardreAdmin")
public class CadreAdministrateur extends Utilisateur {

   private String grade;

public String getGrade() {
	return grade;
}

public void setGrade(String grade) {
	this.grade = grade;
}

   
   
}