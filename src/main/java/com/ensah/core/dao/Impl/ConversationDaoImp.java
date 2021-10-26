package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Conversation;
import com.ensah.core.dao.IConversationDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class ConversationDaoImp extends HibernateSpringGenericDaoImpl<Conversation,Long> implements IConversationDao {

	public ConversationDaoImp() {
		super(Conversation.class);
	}

}
