package com.ensah.core.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte;
import com.ensah.core.dao.ICompteDao;
import com.ensah.genericdao.GenericDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class CompteDaoImpl extends HibernateSpringGenericDaoImpl<Compte, Long> implements ICompteDao{

	public CompteDaoImpl() {
		super(Compte.class);
		// TODO Auto-generated constructor stub
	}
	


	public Compte findByUserName(String username) {
		List<Compte> users = getEntityByColValue("Compte", "login", username);
		return users.size() != 0? users.get(0) : null;
	}

}
