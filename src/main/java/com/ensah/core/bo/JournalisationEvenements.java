package com.ensah.core.bo;


import java.util.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class JournalisationEvenements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEvenement;

	private String details;

	private String adresseIP;

	private Date DateHeure;

	private String typeEvenement;

	private String criticite;

	@ManyToOne
	@JoinColumn(name= "idCompte")
	private Compte compte;

	public Long getIdEvenement() {
		return idEvenement;
	}

	public void setIdEvenement(Long idEvenement) {
		this.idEvenement = idEvenement;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAdresseIP() {
		return adresseIP;
	}

	public void setAdresseIP(String adresseIP) {
		this.adresseIP = adresseIP;
	}

	public Date getDateHeure() {
		return DateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		DateHeure = dateHeure;
	}

	public String getTypeEvenement() {
		return typeEvenement;
	}

	public void setTypeEvenement(String typeEvenement) {
		this.typeEvenement = typeEvenement;
	}

	public String getCriticite() {
		return criticite;
	}

	public void setCriticite(String criticite) {
		this.criticite = criticite;
	}

	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}

	
}