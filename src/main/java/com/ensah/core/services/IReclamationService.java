package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Inscription;
import com.ensah.core.bo.Reclamation;

public interface IReclamationService {
	public Reclamation findReclamationById(Long id);
	
	public List<Reclamation> findReclamationByIns(Long id);
	
	public List<Reclamation> findAllReclamation();
	
	public void addReclamation(Reclamation r);
	
	public void updateReclamation(Reclamation r);
	
	public void deleteReclemation(Long id);

	boolean checkOwnerity(Long id, Long idIscr);

	public Absence getAbsenceByIdNJ(Long ids, Long idIscr);

	Inscription getInscriptionByID(Long id);
}
