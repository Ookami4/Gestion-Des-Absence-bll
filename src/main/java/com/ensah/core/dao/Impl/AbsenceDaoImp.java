package com.ensah.core.dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.ensah.core.bo.Absence;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.genericdao.HibernateSpringGenericDaoImpl;

@Repository
public class AbsenceDaoImp extends HibernateSpringGenericDaoImpl<Absence,Long> implements IAbsenceDao{
	
	public AbsenceDaoImp()
	{
		super(Absence.class);
	}
	
	public List<Absence> findAllByProf(Long idProf)
	{
		return getEntityByColValue("Absence","idEnseignat",String.valueOf(idProf));
	}
	
	public List<Absence> findAllByStudentNJ(Long idStudent)
	{
		return getEntityByColValue("Absence","idInscription",String.valueOf(idStudent));

	}
	
	public List<Absence> findAllByInscription(Long idIns){
		return getEntityByColValue("Absence", "idInscription", String.valueOf(idIns));
	}
	
	public Absence findByIdAbsence(Long IdAbs) {
		return findById(IdAbs);
	}
	
}
