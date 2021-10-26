package com.ensah.core.services;
 
import java.util.List;

import com.ensah.core.bo.Enseignant;

public interface IEnseignantService {

	public void addEnseignant(Enseignant f);

	public void updateEnseignant(Enseignant f);
	
	public List<Enseignant> getAllEnseignants();
	
	public void deleteEnseignant(Long id);
	
	public Enseignant getEnseignantById(Long id);
	

}
