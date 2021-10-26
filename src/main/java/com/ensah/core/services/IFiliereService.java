 package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Filiere;

public interface IFiliereService {

	public void addFiliere(Filiere f);

	public void updateFiliere(Filiere f);
	
	public List<Filiere> getAllFilieres();
	
	public void deleteFiliere(Long id);
	
	public Filiere getFiliereById(Long id);
	
	public List<Filiere> getFiliereBycodeFiliere(String codeFiliere);

}
