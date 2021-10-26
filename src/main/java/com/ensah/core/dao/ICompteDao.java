package com.ensah.core.dao;

import com.ensah.core.bo.Compte;
import com.ensah.genericdao.GenericDao;

public interface ICompteDao extends GenericDao<Compte, Long>{
	public Compte findByUserName(String username);
}
