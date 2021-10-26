 package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Enseignant;
import com.ensah.core.dao.IEnseignantDao;
import com.ensah.core.services.IEnseignantService;

@Service
@Transactional
public class EnseignantServiceImpl implements IEnseignantService {
	
	@Autowired
	private IEnseignantDao EnseignantDao;

	public void addEnseignant(Enseignant f) {
		EnseignantDao.create(f);
	}

	public List<Enseignant> getAllEnseignants() {
		return EnseignantDao.getAll();
	}

	public void deleteEnseignant(Long id) {
		EnseignantDao.delete(id);

	}

	public Enseignant getEnseignantById(Long id) {
		return EnseignantDao.findById(id);

	}

	public void updateEnseignant(Enseignant f) {
		EnseignantDao.update(f);

	}


}
