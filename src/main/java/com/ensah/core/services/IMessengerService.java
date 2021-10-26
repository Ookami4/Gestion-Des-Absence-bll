package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Conversation;
import com.ensah.core.bo.Message;
import com.ensah.core.bo.Utilisateur;

public interface IMessengerService {
	public List<Compte> getUsers(Compte c);
	
	public List<Conversation> getConversationOpened(String username);
	
	public List<Message> getMessagesByConversation(Long c);
	
	public Conversation getConversationById(Long id);
	
	public Long openConversation(Conversation c);
	
	public void addMessage(Message m);
	
	public Utilisateur getUserByUserName(String username);
	
	public Compte getAccByUserName(String username);
	
	public boolean checkParticipation(Conversation c,String username);
	
	public Compte getAccountByID(Long id);
	
	public void updateConversation(Conversation c);
}
