package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.services.IAbsenceService;

@Service
@Transactional
public class AbsenceServiceImp implements IAbsenceService {
	
	@Autowired
	IAbsenceDao absenceDao;
	
	@Override
	public List<Absence> findAllAbsenceByStudentNJ(Long student) {
		return absenceDao.findAllByStudentNJ(student);
	}

	@Override
	public List<Absence> findAllAbsence() {
		return absenceDao.getAll();
	}
	
	@Override
	public List<Absence> getAbsenceByInscription(long id) {
		return absenceDao.findAllByInscription(id);
	}

	@Override
	public Absence findAbsenceById(Long id) {
		return absenceDao.findByIdAbsence(id);
	}

	@Override
	public void addAbsence(Absence data) {
		absenceDao.create(data);
	}
	
	
	@Override
	public void updateAbsence(Absence data) {
		absenceDao.update(data);
	}
	
	@Override
	public void deleteAbsence(Long data) {
		absenceDao.delete(data);
	}
	
	
	@Override
	public boolean absenceExist(Long id) {
		return absenceDao.exists(id);
	}
}
