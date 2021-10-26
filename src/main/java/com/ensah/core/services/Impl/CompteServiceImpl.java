package com.ensah.core.services.Impl;

import java.util.List;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Compte;
import com.ensah.core.bo.Role;
import com.ensah.core.bo.Utilisateur;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IRoleDao;
import com.ensah.core.dao.IUtilisateurDao;
import com.ensah.core.services.ICompteService;
@Service
@Transactional
public class CompteServiceImpl implements  ICompteService{
	
	@Autowired
	private IRoleDao roleDao;
	
	@Autowired
	private IUtilisateurDao userDao;
	
	@Autowired
	private ICompteDao accountDao;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	
	@Override
	public List<Role> getAllRoles() {
		
		return roleDao.getAll();
		
	}

	@Override
	public List<Compte> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountDao.getAll();
	}

	@Override
	public String createAccount(Long idRole, Long idPerson) {

		//first we will find the user 
		
		Utilisateur user = userDao.findById(idPerson);
		
		Compte account = new Compte();
		
		
		account.setProprietaire(user);
		

		
		account.setRole(roleDao.findById(idRole));
		
		String pass = generatePassayPassword();
		
		String password = passwordEncoder.encode(pass);
		
		account.setPassword(password);
		
		//set login, if two users have the same login increment until I say so
		String login = user.getPrenom()+user.getNom();
		int i=0;
		while(true) {
			
			
			if(accountDao.findByUserName(login) != null) {
				login = login+"_"+i;
				i++;
				continue;
			}
			account.setLogin(login);
			break;
		}
		
		accountDao.create(account);
		
		
		
		return pass;
	}

	@Override
	public void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAccount() {
		// TODO Auto-generated method stub
		
	}
	
	
	//generate a random bcrypt password
	public String generatePassayPassword() {
		CharacterRule digits = new CharacterRule(EnglishCharacterData.Digit);

		PasswordGenerator passwordGenerator = new PasswordGenerator();
		String password = passwordGenerator.generatePassword(10, digits);

		return password;
	}
	
	
	
//	public ExcelExporter prepareCompteExport(List<Compte> comptes) {
//		String[] columnNames = new String[] { "Login", "Rôle", "Nom & Prénom" };
//		String[][] data = new String[comptes.size()][3];
//
//		int i = 0;
//		for (Compte u : comptes) {
//			data[i][0] = u.getLogin();
//			data[i][1] = u.getRole().getNomRole();
//			data[i][2] = u.getProprietaire().getNom() +" "+ u.getProprietaire().getPrenom();
//			i++;
//		}
//
//		return new ExcelExporter(columnNames, data, "comptes");
//
//	}
//	
	
	
	

}
