package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue; 
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Module {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   private Long idModule;

   private String titre;

   private String code;
   
   @OneToMany(mappedBy="module",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
   public java.util.Collection<Matiere> matieres;

   @ManyToOne
   @JoinColumn(name="idNiveau")
   public Niveau niveau;
   
   
   public Long getIdModule() {
	return idModule;
   }

	public void setIdModule(Long idModule) {
		this.idModule = idModule;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public Niveau getNiveau() {
		return niveau;
	}
	
	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public java.util.Collection<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(java.util.Collection<Matiere> matieres) {
		this.matieres = matieres;
	}

   

}