package com.ensah.core.dao;

import com.ensah.core.bo.Utilisateur;
import com.ensah.genericdao.GenericDao;

public interface IUtilisateurDao extends GenericDao<Utilisateur, Long>{
	boolean checkIfEmailIsUnique(String email);
	boolean checkIfCINIsUnique(String cin);
	boolean checkIfCNEIsUnique(String cne);
}
