package com.ensah.core.dao;

import java.util.List;

import com.ensah.core.bo.Filiere;
import com.ensah.core.bo.Niveau;
import com.ensah.genericdao.GenericDao;

public interface INiveauDao extends GenericDao<Niveau, Long> {
	public List<Niveau> findByIdFiliere(String idFiliere);
 
}
