package com.ensah.core.dao;

import com.ensah.core.bo.Etudiant;
import com.ensah.genericdao.GenericDao;

public interface IEtudiantDao  extends GenericDao<Etudiant, Long>{
	public Etudiant getByIdUser(Long id);
}
