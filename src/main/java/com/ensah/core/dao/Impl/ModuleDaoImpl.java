package com.ensah.core.dao.Impl;




import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Module; 
import com.ensah.core.dao.IModuleDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class ModuleDaoImpl extends HibernateSpringGenericDaoImpl<Module, Long> implements IModuleDao{

	public ModuleDaoImpl() {
		super(Module.class);
	}

}
