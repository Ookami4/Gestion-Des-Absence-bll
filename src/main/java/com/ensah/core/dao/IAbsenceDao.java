package com.ensah.core.dao;

import java.util.List;

import com.ensah.core.bo.Absence;
import com.ensah.genericdao.GenericDao;

public interface IAbsenceDao  extends GenericDao<Absence, Long> {
	public List<Absence> findAllByProf(Long idProf);
	public Absence findByIdAbsence(Long IdAbs);
	public List<Absence> findAllByStudentNJ(Long idStudent);
	public List<Absence> findAllByInscription(Long id);
}
