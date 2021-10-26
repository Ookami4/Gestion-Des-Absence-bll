package com.ensah.core.services.Impl;

import java.util.ArrayList;

import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ensah.core.bo.Absence;
import com.ensah.core.bo.PieceJustificative;
import com.ensah.core.services.IJustificationService;
import com.ensah.core.dao.IAbsenceDao;
import com.ensah.core.dao.ICompteDao;
import com.ensah.core.dao.IInscriptionDao;
import com.ensah.core.dao.IPieceJustificativeDao;

@Service
@Transactional
public class JustificationServiceImp implements IJustificationService {
	
	@Autowired
	IPieceJustificativeDao pieceDao;
	
	@Autowired
	IAbsenceDao absenceDao;
	
	@Autowired
	ICompteDao accountDao;
	
	@Autowired
	IInscriptionDao insDao;
	
	@Override
	public List<PieceJustificative> findAllByStudent(Long student) {
		List<PieceJustificative> result = new ArrayList<PieceJustificative>();
		for(PieceJustificative i : this.findAllJustification())
		{
			if(i.getAbsence().get(0).getInscription().getIdInscription()==student)
				result.add(i);
		}
		return result;
	}

	@Override
	public List<PieceJustificative> findAllByProfessor(Long prof) {
		List<Absence> absences = absenceDao.findAllByProf(prof);
		List<PieceJustificative> result = new ArrayList<PieceJustificative>();
		for(Absence i : absences)
		{
			result.addAll(pieceDao.getEntityByColValue("PieceJustificative", "idAbsence", String.valueOf(i.getIdAbsence())));
			
		}
		return result;
	}

	@Override
	public PieceJustificative findJustificationById(Long id) {
		return pieceDao.findById(id);
	}

	@Override
	public void addJustification(PieceJustificative data) {
		pieceDao.create(data);
	}

	@Override
	public void updateJustification(PieceJustificative data) {
		pieceDao.update(data);
	}

	@Override
	public void deleteJustification(Long data) {
		pieceDao.delete(data);
	}

	@Override
	public List<PieceJustificative> findAllJustification() {
		return pieceDao.getAll();
	}

	@Override
	public List<Absence> getAbsencesByIdsNJ(Long[] ids, Long idIscr) {
		List<Absence> list = new ArrayList<Absence>();
		for(Long i : ids)
		{
			try {
				Absence tmp = absenceDao.findById(i);
				if(tmp.getEtat()==0 && tmp.getInscription().getIdInscription()==idIscr)
					list.add(tmp);
			}
			catch(Exception e)
			{
				
			}
			
		}
		return list;
	}

	@Override
	public boolean checkOwnerity(Long id,Long idIscr) {
		PieceJustificative jus = this.findJustificationById(id);
		if(jus==null)
			return false;
		if(jus.getAbsence().get(0).getInscription().getIdInscription()!=idIscr)
			return false;
		return true;
	}

	@Override
	public Long getIdIns(String username) {
		if(accountDao.findByUserName(username)==null)
			return null;
		if(accountDao.findByUserName(username).getRole().getIdRole()!=2)
			return null;
		return insDao.getIDByEtuId(accountDao.findByUserName(username).getProprietaire().getIdUtilisateur());
	}

}
