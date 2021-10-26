package com.ensah.core.bo;


import java.util.*;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TypeSeance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTypeSeance;

	private String intitule;

	private String alias;

	@OneToMany(mappedBy = "typeSeance", cascade = CascadeType.ALL, targetEntity = Absence.class)
	private Set<Absence> absences;

	public Long getIdTypeSeance() {
		return idTypeSeance;
	}

	public void setIdTypeSeance(Long idTypeSeance) {
		this.idTypeSeance = idTypeSeance;
	}

	public String getIntitule() {
		return intitule;
	}

	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public Set<Absence> getAbsences() {
		return absences;
	}

	public void setAbsences(Set<Absence> absences) {
		this.absences = absences;
	}
	
	

}