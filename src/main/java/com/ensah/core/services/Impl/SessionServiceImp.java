package com.ensah.core.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.core.services.ISessionService;

@Service
@Transactional
public class SessionServiceImp implements ISessionService {
	@Autowired
	ICompteDao accountDao;
	
	@Autowired
	IInscriptionDao insDao;
	
	@Override
	public Long getIdIns(String username) {
		if(accountDao.findByUserName(username)==null)
			return null;
		if(accountDao.findByUserName(username).getRole().getIdRole()!=4)
			return null;
		return insDao.getIDByEtuId(accountDao.findByUserName(username).getProprietaire().getIdUtilisateur());
	}
}
