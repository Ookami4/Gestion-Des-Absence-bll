package com.ensah.core.services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.Reclamation;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.core.dao.IReclamationDao;
import com.ensah.core.services.IReclamationService;

@Service
@Transactional
public class ReclamationServiceImp implements IReclamationService {
	
	@Autowired
	IReclamationDao dao;
	
	@Autowired
	IAbsenceDao absenceDao;
	
	@Autowired
	IInscriptionDao insDao;
	
	@Override
	public Reclamation findReclamationById(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Reclamation> findReclamationByIns(Long id) {
		return dao.getEntityByColValue("Reclamation", "idInscription", String.valueOf(id));
	}

	@Override
	public List<Reclamation> findAllReclamation() {
		return dao.getAll();
	}

	@Override
	public void addReclamation(Reclamation r) {
		dao.create(r);
	}

	@Override
	public void updateReclamation(Reclamation r) {
		dao.update(r);
	}

	@Override
	public void deleteReclemation(Long id) {
		dao.delete(id);
	}
	
	@Override
	public boolean checkOwnerity(Long id,Long idIscr) {
		Reclamation r = this.findReclamationById(id);
		if(r==null)
			return false;
		if(r.getInscription().getIdInscription()!=idIscr)
			return false;
		return true;
	}
	
	@Override
	public Absence getAbsenceByIdNJ(Long ids, Long idIscr) {
		Absence tmp = absenceDao.findById(ids);
		if(tmp==null)
			return tmp;
		if(tmp.getEtat()==0 && tmp.getInscription().getIdInscription()==idIscr)
			return tmp;
		return null;
	}
	
	@Override
	public Inscription getInscriptionByID(Long id)
	{
		return insDao.findById(id);
	}

}
