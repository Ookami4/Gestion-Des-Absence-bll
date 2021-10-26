package com.ensah.core.dao.Impl;

import java.util.List;

import com.ensah.core.bo.TypeSeance;
import com.ensah.core.dao.ITypeSeanceDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

public class TypeSeanceDaoImpl extends HibernateSpringGenericDaoImpl<TypeSeance, Long> implements ITypeSeanceDao{

	public TypeSeanceDaoImpl() {
		super(TypeSeance.class);
	}
	
}
