package com.ensah.core.bo;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Coordination {
	
   public Coordination() {
		super();
	}


@Override
	public String toString() {
		return "Coordination [idCoordination=" + idCoordination + ", dateDebut=" + dateDebut + ", dateFin=" + dateFin
				+ ", coordonateur=" + coordonateur + ", filiere=" + filiere + "]";
	}


public Coordination(String dateDebut, String dateFin, Enseignant coordonateur, Filiere filiere) throws ParseException {
		super();
		if(!dateDebut.isBlank())
			this.dateDebut = new SimpleDateFormat("yyyy-MM-dd").parse(dateDebut);
		if(!dateFin.isBlank())
			this.dateFin = new SimpleDateFormat("yyyy-MM-dd").parse(dateFin);
		this.coordonateur = coordonateur;
		this.filiere = filiere;
	}


   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)   
   private int idCoordination;

   private java.util.Date dateDebut;

   private java.util.Date dateFin;
   
   @ManyToOne
   @JoinColumn(name="idUtilisateur")
   public Enseignant coordonateur;
   

   @ManyToOne
   @JoinColumn(name="idFiliere")
   public Filiere filiere;


public Filiere getFiliere() {
	return filiere;
}


public void setFiliere(Filiere filiere) {
	this.filiere = filiere;
}


public int getIdCoordination() {
	return idCoordination;
}


public void setIdCoordination(int idCoordination) {
	this.idCoordination = idCoordination;
}


public java.util.Date getDateDebut() {
	return dateDebut;
}


public void setDateDebut(java.util.Date dateDebut) {
	this.dateDebut = dateDebut;
}


public java.util.Date getDateFin() {
	return dateFin;
}


public void setDateFin(java.util.Date dateFin) {
	this.dateFin = dateFin;
}


public Enseignant getCoordonateur() {
	return coordonateur;
}


public void setCoordonateur(Enseignant coordonateur) {
	this.coordonateur = coordonateur;
}

}