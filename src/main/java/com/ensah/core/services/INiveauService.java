package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Niveau; 

public interface INiveauService {

	public void addNiveau(Niveau f);

	public void updateNiveau(Niveau f);
	
	public List<Niveau> getAllNiveaus();
	
	public void deleteNiveau(Long id);
	
	public Niveau getNiveauById(Long id);
	
	public List<Niveau> getNiveausbyFiliere(String idFiliere);
}
