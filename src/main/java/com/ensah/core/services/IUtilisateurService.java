package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Utilisateur;

public interface IUtilisateurService {
	public void addPerson(Utilisateur pPerson, int role);

	public void updatePerson(Utilisateur pPerson, int role);

	public List<Utilisateur> getAllPersons();

	public void deletePerson(Long id);

	public Utilisateur getPersonById(Long id);
	
	public Utilisateur getPersonByCin(String cin);
	
	
	//public ExcelExporter preparePersonExport(List<Utilisateur> persons);
}
