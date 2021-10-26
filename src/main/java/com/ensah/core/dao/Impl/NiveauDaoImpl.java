package com.ensah.core.dao.Impl;



import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Filiere;  
import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.INiveauDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class NiveauDaoImpl extends HibernateSpringGenericDaoImpl<Niveau, Long> implements INiveauDao{

	public NiveauDaoImpl() {
		super(Niveau.class);
	}

	@Override
	public List<Niveau> findByIdFiliere(String idFiliere) {
		return  getEntityByColValue("Niveau", "idFiliere",idFiliere);
	}


}
