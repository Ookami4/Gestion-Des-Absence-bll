package com.ensah.core.dao.Impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Coordination;
import com.ensah.core.dao.ICoordinationDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class CoordinationDaoImpl extends HibernateSpringGenericDaoImpl<Coordination, Long> implements ICoordinationDao{

	public CoordinationDaoImpl() {
		super(Coordination.class);
	}

	@Override
	public List<Coordination> findByIdUtilisateur(String id) {
		return getEntityByColValue("Coordination", "idUtilisateur", id);
	}


}
