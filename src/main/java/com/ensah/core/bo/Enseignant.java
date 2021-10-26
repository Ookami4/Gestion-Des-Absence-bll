package com.ensah.core.bo;


import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "idEnseighant")
public class Enseignant extends Utilisateur {

	private String specialite;

	@OneToMany(mappedBy = "observateur", cascade = CascadeType.ALL, targetEntity = Absence.class)
	private List<Absence> absencesMarquees;

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	public List<Absence> getAbsencesMarquees() {
		return absencesMarquees;
	}

	public void setAbsencesMarquees(List<Absence> absencesMarquees) {
		this.absencesMarquees = absencesMarquees;
	}

}