package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Etudiant;

public interface IFormAbsService {
	public List<Compte> getStudent();
	
	public List<Absence> getAbsenceByStudent(Long id_ins);
	

}
