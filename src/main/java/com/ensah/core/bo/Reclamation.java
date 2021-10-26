package com.ensah.core.bo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Reclamation {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReclamation;
	
	private String title;
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(columnDefinition="TEXT")
	private String text;
	
	@Column(columnDefinition="TEXT")
	private String reponse;
	
	private boolean answered;
	
	@ManyToOne
	@JoinColumn(name = "idInscription")
	private Inscription inscription;
	
	@ManyToOne
	@JoinColumn(name = "idAbsence")
	private Absence absence;

	public Absence getAbsence() {
		return absence;
	}

	public void setAbsence(Absence absence) {
		this.absence = absence;
	}

	public Long getIdReclamation() {
		return idReclamation;
	}

	public void setIdReclamation(Long idReclamation) {
		this.idReclamation = idReclamation;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public boolean isAnswered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public Inscription getInscription() {
		return inscription;
	}

	public void setInscription(Inscription inscription) {
		this.inscription = inscription;
	}
	
	public void removeAbsence()
	{
		this.absence.getReclamations().remove(this);
		this.absence=null;
	}
	
	public void addAbsence()
	{
		this.absence.getReclamations().add(this);
	}
	
	public void removeInscription()
	{
		this.inscription.getReclamations().remove(this);
		this.inscription=null;
	}
	
	public void addInscription()
	{
		this.inscription.getReclamations().add(this);
	}
}
