package com.ensah.core.services.Impl;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.transaction.annotation.Transactional;


import org.springframework.beans.factory.annotation.Autowired;

import com.ensah.core.bo.Etudiant;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.exceptions.EntityNotUnique;
import com.ensah.core.services.IUtilisateurService;

import org.springframework.stereotype.Service;


@Service
@Transactional
public class UtilisateurServiceImpl  implements IUtilisateurService{
	
	@Autowired
	private IUtilisateurDao userDao;

	@Override
	@Transactional
	public void addPerson(Utilisateur pPerson, int role) {
		
		System.out.println("inside utilisateur service");
		
		if(!userDao.checkIfEmailIsUnique(pPerson.getEmail())) {
			throw new EntityNotUnique(pPerson.getClass(), "email");
		}
		
		//si cne n'est pas unique
		if(!userDao.checkIfCINIsUnique(pPerson.getCin())) {
			System.err.println("inside service add person chek cin is unique");
			throw new EntityNotUnique(Utilisateur.class, "cin");
		}
		
		//si une etudiant a entréé un cne déja dans la base de donnée
		if(role == 3 && pPerson instanceof Etudiant) {
			Etudiant etud = (Etudiant)pPerson;
			
			if(!userDao.checkIfCNEIsUnique(etud.getCne())) {
				throw new EntityNotUnique(Etudiant.class, "cne");
			}
		}
		
		userDao.create(pPerson);
		
	}

	@Override
	public void updatePerson(Utilisateur pPerson, int role) {
		userDao.update(pPerson);
		
	}

	@Override
	public List<Utilisateur> getAllPersons() {
		return userDao.getAll();
	}

	@Override
	public void deletePerson(Long id) {
		
		if(!userDao.exists(id)){
			throw new EntityNotFoundException("L'id "+id+" de l'utilisateur ,n'est pas trouvé.");	
		}
		userDao.delete(id);
	}

	@Override
	public Utilisateur getPersonById(Long id) {
		return userDao.findById(id);
	}

	@Override
	public Utilisateur getPersonByCin(String cin) {

		List<Utilisateur> users =  userDao.getEntityByColValue("Utilisateur", "cin", cin);
		
		if(users != null && users.size() != 0) {
			return users.get(0);
		}
		
		return null;
	}


	
	
	
	
	
}
