package com.ensah.core.services;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.PieceJustificative;
import java.util.List;

public interface IJustificationService {
	public List<PieceJustificative> findAllByStudent(Long student);
	
	public List<PieceJustificative> findAllByProfessor(Long prof);
	
	public List<PieceJustificative> findAllJustification();
	
	public PieceJustificative findJustificationById(Long id);
	
	public void addJustification(PieceJustificative data);
	
	public void updateJustification(PieceJustificative data);
	
	public void deleteJustification(Long data);
	
	public List<Absence> getAbsencesByIdsNJ(Long[] ids,Long idIscr);
	
	public boolean checkOwnerity(Long id,Long idIscr);
	
	public Long getIdIns(String username);
}
