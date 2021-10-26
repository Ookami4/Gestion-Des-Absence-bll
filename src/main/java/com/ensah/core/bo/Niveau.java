package com.ensah.core.bo;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType; 
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Niveau {

	public Niveau() {
		super();
	}
   public Niveau(String alias, String titre,Filiere filiere) {
		super();
		this.alias = alias;
		this.titre = titre;
		this.filiere = filiere;
	}

   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY) 
   private Long idNiveau;

   private String alias;

   private String titre;

   @ManyToOne
   @JoinColumn(name="idFiliere")
   public Filiere filiere;

   @OneToMany(mappedBy="niveau", cascade=CascadeType.ALL, targetEntity = Module.class)
   public java.util.Collection<Module> modules;
   
   @OneToMany(mappedBy="niveau", cascade=CascadeType.ALL,  targetEntity = Inscription.class)
   public java.util.Collection<Inscription> Inscriptions;
   
   public Long getIdNiveau() {
		return idNiveau;
	}
	
	public void setIdNiveau(Long idNiveau) {
		this.idNiveau = idNiveau;
	}
	
	public String getAlias() {
		return alias;
	}
	
	public void setAlias(String alias) {
		this.alias = alias;
	}
	
	public String getTitre() {
		return titre;
	}
	
	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Filiere getFiliere() {
		return filiere;
	}
	
	public void setFiliere(Filiere filiere) {
		this.filiere = filiere;
	}
   
  
}