package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Filiere {
	
   public Filiere() {
		super();
	}

   public Filiere(String titreFiliere, String codeFiliere, int anneeaccreditation, int anneeFinaccreditation) {
		super();
		
		this.titreFiliere = titreFiliere;
		this.codeFiliere = codeFiliere;
		this.anneeaccreditation = anneeaccreditation;
		this.anneeFinaccreditation = anneeFinaccreditation;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long idFiliere;

   private String titreFiliere;
   
   @Column(unique = true)
   private String codeFiliere;

   private int anneeaccreditation;
   private int anneeFinaccreditation;

   @OneToMany(mappedBy="filiere", cascade=CascadeType.ALL)
   public java.util.Collection<Niveau> niveaux;

   @OneToMany(mappedBy="filiere",fetch = FetchType.EAGER,cascade=CascadeType.ALL)
   public java.util.Collection<Coordination> periodeCoordination=new LinkedHashSet<Coordination>();
   

	public java.util.Collection<Niveau> getNiveaux() {
	return niveaux;
}

public void setNiveaux(java.util.Collection<Niveau> niveaux) {
	this.niveaux = niveaux;
}

public java.util.Collection<Coordination> getPeriodeCoordination() {
	return periodeCoordination;
}

public void setPeriodeCoordination(java.util.Collection<Coordination> periodeCoordination) {
	this.periodeCoordination = periodeCoordination;
}

	public Long getIdFiliere() {
		return idFiliere;
	}

	public void setIdFiliere(Long idFiliere) {
		this.idFiliere = idFiliere;
	}

	public String getTitreFiliere() {
		return titreFiliere;
	}

	public void setTitreFiliere(String titreFiliere) {
		this.titreFiliere = titreFiliere;
	}

	public String getCodeFiliere() {
		return codeFiliere;
	}

	public void setCodeFiliere(String codeFiliere) {
		this.codeFiliere = codeFiliere;
	}

	public int getAnneeaccreditation() {
		return anneeaccreditation;
	}

	public void setAnneeaccreditation(int anneeaccreditation) {
		this.anneeaccreditation = anneeaccreditation;
	}

	public int getAnneeFinaccreditation() {
		return anneeFinaccreditation;
	}

	public void setAnneeFinaccreditation(int anneeFinaccreditation) {
		this.anneeFinaccreditation = anneeFinaccreditation;
	}



}