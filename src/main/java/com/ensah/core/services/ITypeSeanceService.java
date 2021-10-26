package com.ensah.core.services;

import java.util.List;

import com.ensah.core.bo.TypeSeance;

public interface ITypeSeanceService {
	
	public List<TypeSeance> getAllTypeSeance();
	
	public TypeSeance getTypeSeanceByIdT(Long idType);
}
