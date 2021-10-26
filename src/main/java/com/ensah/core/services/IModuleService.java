 package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Module;

public interface IModuleService {

	public void addModule(Module f);

	public void updateModule(Module f);
	
	public List<Module> getAllModules();
	
	public void deleteModule(Long id);
	
	public Module getModuleById(Long id);
	
}
