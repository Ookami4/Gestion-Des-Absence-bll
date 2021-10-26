package com.ensah.core.dao.Impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Filiere; 
import com.ensah.core.bo.Matiere;
import com.ensah.core.dao.IMatiereDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class MatiereDaoImpl extends HibernateSpringGenericDaoImpl<Matiere, Long> implements IMatiereDao{

	public MatiereDaoImpl() {
		super(Matiere.class);
	}



}
