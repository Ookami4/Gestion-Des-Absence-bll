 package com.ensah.core.services.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Module;
import com.ensah.core.dao.IModuleDao;
import com.ensah.core.services.IModuleService;

@Service
@Transactional
public class ModuleServiceImpl implements IModuleService {
	
	@Autowired
	private IModuleDao ModuleDao;

	public void addModule(Module f) {
		ModuleDao.create(f);
	}

	public List<Module> getAllModules() {
		return ModuleDao.getAll();
	}

	public void deleteModule(Long id) {
		ModuleDao.delete(id);

	}

	public Module getModuleById(Long id) {
		return ModuleDao.findById(id);

	}

	public void updateModule(Module f) {
		ModuleDao.update(f);

	}

}
