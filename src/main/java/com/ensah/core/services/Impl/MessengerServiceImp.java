package com.ensah.core.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Conversation;
import com.ensah.core.bo.Message;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IConversationDao;
import com.ensah.core.dao.IMessageDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IMessengerService;

@Service
@Transactional
public class MessengerServiceImp implements IMessengerService {
	@Autowired
	private IUtilisateurDao userDao;
	
	@Autowired
	private ICompteDao accDao;
	
	@Autowired
	private IMessageDao messageDao;
	
	@Autowired
	private IConversationDao convDao;

	@Override
	public List<Compte> getUsers(Compte c) {
		List<Compte> res = new ArrayList<Compte>();
		if(c==null)
			return res;
		List<Compte> list = accDao.getAll();
		for(Compte i : list)
		{
			if(i.getIdCompte()!=c.getIdCompte())
				res.add(i);
		}
		return res;
	}

	@Override
	public List<Conversation> getConversationOpened(String c) {
		Compte cmp = this.accDao.findByUserName(c);
		if(cmp==null)
			return null;
		List<Conversation> list = new ArrayList<Conversation>();
		for(Conversation cnv : this.convDao.getAll())
		{
			if(cnv.getParticipant().contains(cmp))
			{
				list.add(cnv);
			}
		}
		return list;
	}

	@Override
	public List<Message> getMessagesByConversation(Long c) {
		Conversation cnv = this.getConversationById(c);
		if(cnv==null)
			return null;
		return cnv.getMessages();
	}

	@Override
	public Conversation getConversationById(Long id) {
		return this.convDao.findById(id);
	}

	@Override
	public Long openConversation(Conversation c) {
		return this.convDao.create(c);
	}
	
	@Override
	public void updateConversation(Conversation c) {
		if(c==null)
			return;
		this.convDao.update(c);
	}

	@Override
	public void addMessage(Message m) {
		this.messageDao.create(m);
	}

	@Override
	public Utilisateur getUserByUserName(String username) {
		if(accDao.findByUserName(username)==null)
			return null;
		return accDao.findByUserName(username).getProprietaire();
	}
	
	@Override
	public Compte getAccByUserName(String username) {
		if(accDao.findByUserName(username)==null)
			return null;
		return accDao.findByUserName(username);
	}
	
	@Override
	public boolean checkParticipation(Conversation c,String username)
	{
		Compte mine = this.getAccByUserName(username);
		if(mine==null)
			return false;
		if(c==null)
			return false;
		for(Compte cmp : c.getParticipant())
		{
			if(cmp.getIdCompte()==mine.getIdCompte())
				return true;
		}
		return false;
	}
	
	@Override
	public Compte getAccountByID(Long id)
	{
		return this.accDao.findById(id);
	}
}
