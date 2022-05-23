/**
 * 
 */
package com.immobilier.agence.model;



import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



/**
 * @author Boubacar
 *
 */

@Entity
public class Bail {

	@Id
	@GeneratedValue
	private Long idBail;
	private String referenceBail;
	private float caution;
	@CreationTimestamp
	private LocalDate dateBail;
	private float montatantBail;
	private float montantPenalite;
	private int dureeBail;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "BIEN_ID")
	private Bien bien;
	
	
	public Bail() {
		super();
	}

	public Bail(String referenceBail, float caution, float montantPenalite, Bien bien) {
		super();
		this.setReferenceBail(referenceBail);
		this.caution = caution;
		this.montantPenalite = montantPenalite;
		this.bien = bien;
	}

	public Long getIdBail() {
		return idBail;
	}

	public void setIdBail(Long idBail) {
		this.idBail = idBail;
	}

	public String getReferenceBail() {
		return referenceBail;
	}

	public void setReferenceBail(String referenceBail) {
		this.referenceBail = referenceBail;
	}

	public LocalDate getDateBail() {
		return dateBail;
	}

	public void setDateBail(LocalDate dateBail) {
		this.dateBail = dateBail;
	}

	public float getCaution() {
		return caution;
	}

	public void setCaution(float caution) {
		this.caution = caution;
	}

	public float getMontantPenalite() {
		return montantPenalite;
	}

	public void setMontantPenalite(float montantPenalite) {
		this.montantPenalite = montantPenalite;
	}



	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public float getMontatantBail() {
		return montatantBail;
	}

	public void setMontatantBail(float montatantBail) {
		this.montatantBail = montatantBail;
	}

	public int getDureeBail() {
		return dureeBail;
	}

	public void setDureeBail(int dureeBail) {
		this.dureeBail = dureeBail;
	}

	
}
