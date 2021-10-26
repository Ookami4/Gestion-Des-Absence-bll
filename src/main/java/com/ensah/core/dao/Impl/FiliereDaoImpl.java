package com.ensah.core.dao.Impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte; 
import com.ensah.core.bo.Filiere;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class FiliereDaoImpl extends HibernateSpringGenericDaoImpl<Filiere, Long> implements IFiliereDao{

	public FiliereDaoImpl() {
		super(Filiere.class);
	}

	@Override
	public List<Filiere> findByCodeFiliere(String codeFiliere) {
		return getEntityByColValue("Filiere", "codeFiliere", codeFiliere);
	}

}
