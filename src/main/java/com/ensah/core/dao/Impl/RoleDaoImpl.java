package com.ensah.core.dao.Impl;

import org.springframework.stereotype.Repository;


import com.ensah.core.bo.Role;
import com.ensah.core.dao.IRoleDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;
@Repository
public class RoleDaoImpl extends HibernateSpringGenericDaoImpl<Role, Long> implements IRoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

}
