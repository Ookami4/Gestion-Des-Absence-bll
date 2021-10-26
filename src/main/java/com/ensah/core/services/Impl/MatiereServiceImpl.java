 package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Matiere;
import com.ensah.core.dao.IMatiereDao;
import com.ensah.core.services.IMatiereService;

@Service
@Transactional
public class MatiereServiceImpl implements IMatiereService {
	
	@Autowired
	private IMatiereDao MatiereDao;

	public void addMatiere(Matiere f) {
		MatiereDao.create(f);
	}

	public List<Matiere> getAllMatieres() {
		return MatiereDao.getAll();
	}

	public void deleteMatiere(Long id) {
		MatiereDao.delete(id);

	}

	public Matiere getMatiereById(Long id) {
		return MatiereDao.findById(id);

	}

	public void updateMatiere(Matiere f) {
		MatiereDao.update(f);

	}

}
