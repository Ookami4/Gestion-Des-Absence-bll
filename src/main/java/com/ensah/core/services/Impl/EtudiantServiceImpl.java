package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.dao.IEtudiantDao;
import com.ensah.core.services.IEtudiantService;

@Service
@Transactional
public class EtudiantServiceImpl implements IEtudiantService{
	
	@Autowired
	IEtudiantDao etdDao;
	
	@Override
	public List<Etudiant> getAllEtudiants() {
		return etdDao.getAll();
	}

	@Override
	public Etudiant getEtudiantById(Long id) {
		return etdDao.findById(id);
	}

}
