 package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Coordination;

public interface ICoordinationService {

	public void addCoordination(Coordination f);

	public void updateCoordination(Coordination f);
	
	public List<Coordination> getAllCoordinations();
	
	public void deleteCoordination(Long id);
	
	public Coordination getCoordinationById(Long id);

	public List<Coordination> getCoordinationByIdUtilisateur(String id);


}
