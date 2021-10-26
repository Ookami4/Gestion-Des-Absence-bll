package com.ensah.core.dao;
 
import java.util.List;

import com.ensah.core.bo.Filiere;
import com.ensah.genericdao.GenericDao;

public interface IFiliereDao extends GenericDao<Filiere, Long> {
	public List<Filiere> findByCodeFiliere(String titreFiliere);
}
 