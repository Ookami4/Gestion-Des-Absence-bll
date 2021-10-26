package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.TypeSeance;
import com.ensah.core.dao.ITypeSeanceDao;
import com.ensah.core.services.ITypeSeanceService;

@Service
@Transactional

public class TypeSeanceServiceImpl implements ITypeSeanceService {
	
	@Autowired
	ITypeSeanceDao tpSeanceDao;
	
	@Override
	public List<TypeSeance> getAllTypeSeance() {
		return tpSeanceDao.getAll();
	}

	@Override
	public TypeSeance getTypeSeanceByIdT(Long idType) {
		return tpSeanceDao.findById(idType);
	}

}
