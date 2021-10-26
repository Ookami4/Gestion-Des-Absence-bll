package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Reclamation;
import com.ensah.core.dao.IReclamationDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class ReclamationDaoImp extends HibernateSpringGenericDaoImpl<Reclamation,Long> implements IReclamationDao {
	public ReclamationDaoImp()
	{
		super(Reclamation.class);
	}
}
