package com.ensah.core.bo;

import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Inscription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idInscription;

	private int annee;

	private int etat;

	@ManyToOne
	@JoinColumn(name="idNiveau")
	private Niveau niveau;

	@ManyToOne
	@JoinColumn(name="idEtudiant")
	private Etudiant etudiant;
	
	@OneToMany(mappedBy = "inscription" , cascade = CascadeType.ALL , targetEntity = Absence.class)
	private List<Absence> absences;
	
	@OneToMany(mappedBy = "inscription" , cascade = CascadeType.ALL)
	private Set<Reclamation> reclamations;
	
	public Set<Reclamation> getReclamations() {
		return reclamations;
	}

	public void setReclamations(Set<Reclamation> reclamations) {
		this.reclamations = reclamations;
	}

	public Long getIdInscription() {
		return idInscription;
	}

	public void setIdInscription(Long idInscription) {
		this.idInscription = idInscription;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public List<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(List<Absence> absences) {
		this.absences = absences;
	}

	
	
}