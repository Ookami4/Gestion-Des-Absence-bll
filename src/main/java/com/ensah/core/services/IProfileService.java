package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.Utilisateur;

public interface IProfileService {
	public Utilisateur getUserByUserName(String username);
	
	public void UpdateDetails(Utilisateur u, String email,String tel,byte[] photo);

	List<Absence> getAbsences(Long idIns);
}
