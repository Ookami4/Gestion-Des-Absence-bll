package com.ensah.core.bo;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMessage;

	@Column(columnDefinition="TEXT")
	private String texte;

	private Date dateHeure;

	@ManyToOne
	@JoinColumn(name="idConversation")
	private Conversation conversation;

	@ManyToOne
	@JoinColumn(name="idExpediteur")
	private Compte expediteur;

	@ManyToOne
	@JoinColumn(name="idDestinataire")
	private Compte destinataire;

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public String getTexte() {
		return texte;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public Date getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(Date dateHeure) {
		this.dateHeure = dateHeure;
	}

	public Conversation getConversation() {
		return conversation;
	}

	public void setConversation(Conversation conversation) {
		this.conversation = conversation;
	}

	public Compte getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Compte expediteur) {
		this.expediteur = expediteur;
	}

	public Compte getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(Compte destinataire) {
		this.destinataire = destinataire;
	}
	
	public void addParticipant(Compte s,Compte r)
	{
		this.expediteur=s;
		this.destinataire=r;
		s.getMessagesEnvoyes().add(this);
		r.getmessagesRecus().add(this);
	}

}