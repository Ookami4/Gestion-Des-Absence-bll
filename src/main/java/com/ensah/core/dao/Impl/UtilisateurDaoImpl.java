package com.ensah.core.dao.Impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class UtilisateurDaoImpl extends HibernateSpringGenericDaoImpl<Utilisateur, Long> implements IUtilisateurDao {

	public UtilisateurDaoImpl() {
		super(Utilisateur.class);
	}

	@Override
	public boolean checkIfEmailIsUnique(String email) {
		List<Utilisateur> emails = getEntityByColValue("Utilisateur", "email", email);
		
		return emails.size() == 0 ? true : false;
	}

	@Override
	public boolean checkIfCINIsUnique(String cin) {
		List<Utilisateur> cins = getEntityByColValue("Utilisateur", "cin", cin);
		System.out.println(cins.toString());
		return cins.size() == 0 ? true : false;
	}

	@Override
	public boolean checkIfCNEIsUnique(String cne) {
		List<Utilisateur> cnes = getEntityByColValue("Utilisateur", "cne", cne);
		
		return cnes.size() == 0 ? true : false;
	}

}
