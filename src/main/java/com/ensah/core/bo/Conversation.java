package com.ensah.core.bo;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Conversation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConversation;

	private String type;

	private String titre;

	private int etat;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(name = "idConversation"), 
	inverseJoinColumns = @JoinColumn(name = "idParticipant"))
	private List<Compte> participant;

	@OneToMany(mappedBy = "conversation" , cascade = CascadeType.ALL, targetEntity = Message.class)
	private List<Message> messages;

	@ManyToOne
	@JoinColumn(name="idCreateur")
	private Compte createurConversation;

	public Long getIdConversation() {
		return idConversation;
	}

	public void setIdConversation(Long idConversation) {
		this.idConversation = idConversation;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public int getEtat() {
		return etat;
	}

	public void setEtat(int etat) {
		this.etat = etat;
	}

	public List<Compte> getParticipant() {
		return participant;
	}

	public void setParticipant(List<Compte> participant) {
		this.participant = participant;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Compte getCreateurConversation() {
		return createurConversation;
	}

	public void setCreateurConversation(Compte createurConversation) {
		this.createurConversation = createurConversation;
	}
	
	
	public void addAccount(Compte c)
	{
		if(this.participant==null)
			this.participant = new ArrayList<Compte>();
		this.participant.add(c);
		c.getConversationRecues().add(this);
	}
	
	public void addCreator(Compte c)
	{
		this.createurConversation=c;
		c.getConversationsCrees().add(this);
	}

}