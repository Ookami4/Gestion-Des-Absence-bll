package com.ensah.core.bo;

import java.util.*;

import javax.persistence.Entity; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Matiere {
 
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idMatiere;

   private String nom;

   private String code;
   
   @ManyToOne
   @JoinColumn(name="idModule")
   public Module module;
   
 
   public Long getIdMatiere() {
 		return idMatiere;
 	}

 	public void setIdMatiere(Long idMatiere) {
 		this.idMatiere = idMatiere;
 	}

 	public String getNom() {
 		return nom;
 	}

 	public void setNom(String nom) {
 		this.nom = nom;
 	}

 	public String getCode() {
 		return code;
 	}

 	public void setCode(String code) {
 		this.code = code;
 	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}


}