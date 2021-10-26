package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.dao.IEtudiantDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class EtudiantDaoImp extends HibernateSpringGenericDaoImpl<Etudiant,Long> implements IEtudiantDao {
	public EtudiantDaoImp()
	{
		super(Etudiant.class);
	}
	
	@Override
	public Etudiant getByIdUser(Long id)
	{
		return this.getEntityByColValue("Etudiant","idEtudiant", String.valueOf(id)).get(0);
	}
}
