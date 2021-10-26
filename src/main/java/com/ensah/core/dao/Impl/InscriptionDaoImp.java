package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;


import com.ensah.core.bo.Inscription;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class InscriptionDaoImp extends HibernateSpringGenericDaoImpl<Inscription,Long> implements IInscriptionDao {
	public InscriptionDaoImp()
	{
		super(Inscription.class);
	}

	@Override
	public Long getIDByEtuId(Long etu) {
		return this.getEntityByColValue("Inscription", "idEtudiant",String.valueOf(etu)).get(0).getIdInscription();
	}
}
