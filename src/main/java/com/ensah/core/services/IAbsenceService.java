package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;

public interface IAbsenceService {
	public List<Absence> findAllAbsenceByStudentNJ(Long student);
	
	public List<Absence> findAllAbsence();
	
	public Absence findAbsenceById(Long id);
	
	public void addAbsence(Absence data);
	
	public List<Absence> getAbsenceByInscription(long id);
	
	public void updateAbsence(Absence data);
	
	public void deleteAbsence(Long id);
	public boolean absenceExist(Long id);
}
