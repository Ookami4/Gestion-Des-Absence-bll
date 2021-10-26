package com.ensah.core.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Compte;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.IFormAbsService;

@Service
@Transactional
public class FormAbsServiceImpl implements IFormAbsService {
	
	@Autowired
	ICompteDao accountDao;
	
	@Autowired
	IUtilisateurDao userDao;
	
	@Autowired
	IAbsenceDao absDao;

	@Override
	public List<Compte> getStudent() {
		List<Compte> list = accountDao.getAll();
		List<Compte> res = new ArrayList<Compte>();
		
		for(Compte c : list) {
			if(c.getRole().getIdRole() == 4) {
				res.add(c);
			}
		}
		return res;
	}

	@Override
	public List<Absence> getAbsenceByStudent(Long id_ins) {
		return absDao.getEntityByColValue("Absence", "idInscription", String.valueOf(id_ins));
	}

	
	

}
