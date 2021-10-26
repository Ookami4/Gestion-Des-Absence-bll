package com.ensah.core.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.dao.IPieceJustificativeDao;
import com.ensah.genericdao.EntityNotFoundException;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
@Repository
public class PieceJustificationDaoImp extends HibernateSpringGenericDaoImpl<PieceJustificative,Long> implements IPieceJustificativeDao {
	public PieceJustificationDaoImp()
	{
		super(PieceJustificative.class);
	}
}
