package com.ensah.core.bo;

/***********************************************************************

 /***********************************************************************

 * Module:  Utilisateur.java
 * Author:  Hp
 * Purpose: Defines the Class Utilisateur
 ***********************************************************************/

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Utilisateur {

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name="increment" , strategy = "increment")
	private Long idUtilisateur;

	private String nom;

	private String prenom;
    @Column(unique=true)
	private String cin;
    @Column(unique=true)
	private String email;

	private String telephone;

	private String nomArabe;

	private String prenomArabe;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
	private byte[] photo;

	@OneToMany(mappedBy = "proprietaire" , cascade = CascadeType.ALL, targetEntity = Compte.class)
	private Set<Compte> comptes;

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNomArabe() {
		return nomArabe;
	}

	public void setNomArabe(String nomArabe) {
		this.nomArabe = nomArabe;
	}

	public String getPrenomArabe() {
		return prenomArabe;
	}

	public void setPrenomArabe(String prenomArabe) {
		this.prenomArabe = prenomArabe;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Set<Compte> getComptes() {
		return comptes;
	}

	public void setComptes(Set<Compte> comptes) {
		this.comptes = comptes;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin
				+ ", email=" + email + ", telephone=" + telephone + ", nomArabe=" + nomArabe + ", prenomArabe="
				+ prenomArabe + ", photo=" + photo + ", comptes=" + comptes + "]";
	}
	
	   public void addComptes(Compte newCompte) {
		      if (newCompte == null)
		         return;
		      if (this.comptes == null)
		         this.comptes = new java.util.HashSet<Compte>();
		      if (!this.comptes.contains(newCompte))
		      {
		         this.comptes.add(newCompte);
		         newCompte.setProprietaire(this);      
		      }
		   }
		   
		   /** @pdGenerated default remove
		     * @param oldCompte */
		   public void removeComptes(Compte oldCompte) {
		      if (oldCompte == null)
		         return;
		      if (this.comptes != null)
		         if (this.comptes.contains(oldCompte))
		         {
		            this.comptes.remove(oldCompte);
		            oldCompte.setProprietaire((Utilisateur)null);
		         }
		   }
	
	

}