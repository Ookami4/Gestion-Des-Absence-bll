package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IProfileService;

@Service
@Transactional
public class ProfileServiceImp implements IProfileService {
	@Autowired
	ICompteDao accountDao;
	
	@Autowired
	IUtilisateurDao userDao;
	
	@Autowired
	IAbsenceDao absDao;

	@Override
	public Utilisateur getUserByUserName(String username) {
		if(accountDao.findByUserName(username)==null)
			return null;
		return accountDao.findByUserName(username).getProprietaire();
	}

	@Override
	public void UpdateDetails(Utilisateur u, String email, String tel, byte[] photo) {
		u.setPhoto(photo); 
		u.setEmail(email);
		u.setTelephone(tel);
		userDao.update(u);
	}
	
	@Override
	public List<Absence> getAbsences(Long idIns)
	{
		return absDao.getEntityByColValue("Absence", "idInscription", String.valueOf(idIns));
	}

}
