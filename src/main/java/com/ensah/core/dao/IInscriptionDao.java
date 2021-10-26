package com.ensah.core.dao;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Inscription;
import com.ensah.genericdao.GenericDao;

public interface IInscriptionDao  extends GenericDao<Inscription, Long> {
	public Long getIDByEtuId(Long etu);
	
}
