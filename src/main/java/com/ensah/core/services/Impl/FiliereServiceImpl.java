  package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Filiere;
import com.ensah.core.dao.IFiliereDao;
import com.ensah.core.services.IFiliereService;

@Service
@Transactional
public class FiliereServiceImpl implements IFiliereService {
	
	@Autowired
	private IFiliereDao filiereDao;

	public void addFiliere(Filiere f) {
		filiereDao.create(f);
	}

	public List<Filiere> getAllFilieres() {
		return filiereDao.getAll();
	}

	public void deleteFiliere(Long id) {
		filiereDao.delete(id);

	}

	public Filiere getFiliereById(Long id) {
		return filiereDao.findById(id);

	}

	public void updateFiliere(Filiere f) {
		filiereDao.update(f);

	}

	@Override
	public List<Filiere> getFiliereBycodeFiliere(String codeFiliere) {
		return filiereDao.findByCodeFiliere(codeFiliere);
		
	}


}
