 package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Coordination;
import com.ensah.core.dao.ICoordinationDao;
import com.ensah.core.services.ICoordinationService;

@Service
@Transactional
public class CoordinationServiceImpl implements ICoordinationService {
	
	@Autowired
	private ICoordinationDao CoordinationDao;

	public void addCoordination(Coordination f) {
		CoordinationDao.create(f);
	}

	public List<Coordination> getAllCoordinations() {
		return CoordinationDao.getAll();
	}

	public void deleteCoordination(Long id) {
		CoordinationDao.delete(id);

	}

	public Coordination getCoordinationById(Long id) {
		return CoordinationDao.findById(id);

	}

	public void updateCoordination(Coordination f) {
		CoordinationDao.update(f);

	}

	@Override
	public List<Coordination> getCoordinationByIdUtilisateur(String id) {
		return CoordinationDao.findByIdUtilisateur(id);
	}

	


}
