package com.ensah.core.services;



import java.util.List;


import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Role;


public interface ICompteService {
	
	public List<Role> getAllRoles();
	
	public List<Compte> getAllAccounts();

	public String createAccount(Long idRole, Long idPerson);
	
	public void deleteAccount();
	
	public void updateAccount();
	
	//public ExcelExporter prepareCompteExport(List<Compte> comptes) ;
}
