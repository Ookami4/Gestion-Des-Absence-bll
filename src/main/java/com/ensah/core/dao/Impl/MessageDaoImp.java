package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Message;
import com.ensah.core.dao.IMessageDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class MessageDaoImp extends HibernateSpringGenericDaoImpl<Message,Long> implements IMessageDao {
	public MessageDaoImp()
	{
		super(Message.class);
	}
}
