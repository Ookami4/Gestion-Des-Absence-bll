package com.ensah.core.services.Impl;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Niveau;
import com.ensah.core.dao.INiveauDao;
import com.ensah.core.services.INiveauService;

@Service
@Transactional
public class NiveauServiceImpl implements INiveauService {
	
	@Autowired
	private INiveauDao NiveauDao;

	public void addNiveau(Niveau f) {
		NiveauDao.create(f);
	}

	public List<Niveau> getAllNiveaus() {
		return NiveauDao.getAll();
	}

	public void deleteNiveau(Long id) {
		NiveauDao.delete(id);

	}

	public Niveau getNiveauById(Long id) {
		return NiveauDao.findById(id);

	}

	public void updateNiveau(Niveau f) {
		NiveauDao.update(f);

	}

	@Override
	public List<Niveau> getNiveausbyFiliere(String idFiliere) {
		return NiveauDao.findByIdFiliere(idFiliere);
	}
}
