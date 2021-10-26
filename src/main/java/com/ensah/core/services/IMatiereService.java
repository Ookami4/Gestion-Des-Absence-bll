  package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Matiere;

public interface IMatiereService {

	public void addMatiere(Matiere f);

	public void updateMatiere(Matiere f);
	
	public List<Matiere> getAllMatieres();
	
	public void deleteMatiere(Long id);
	
	public Matiere getMatiereById(Long id);
	
}
