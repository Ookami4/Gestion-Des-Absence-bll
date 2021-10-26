package com.ensah.core.dao;

import java.util.List;

import com.ensah.core.bo.Coordination;
import com.ensah.genericdao.GenericDao;

public interface ICoordinationDao extends GenericDao<Coordination, Long> {
	public List<Coordination> findByIdUtilisateur(String id);

}
 