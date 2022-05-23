package com.immobilier.agence.model;

import java.time.LocalDateTime;

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
public class BienRestituer {

	@Id
	@GeneratedValue
	private Long idBienRestituer;
	private float penalite;
	@CreationTimestamp
	private LocalDateTime dateRestition;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "BAIL_ID")
	private Bien bien;
	
	
	public BienRestituer() {
	super();
	}
	
	public BienRestituer(float penalite, Bien bien) {
		super();
		this.penalite = penalite;
		this.bien = bien;
	}

	public Long getIdBienRestituer() {
		return idBienRestituer;
	}

	public void setIdBienRestituer(Long idBienRestituer) {
		this.idBienRestituer = idBienRestituer;
	}

	public float getPenalite() {
		return penalite;
	}

	public void setPenalite(float penalite) {
		this.penalite = penalite;
	}

	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}


	public LocalDateTime getDateRestition() {
		return dateRestition;
	}

	public void setDateRestition(LocalDateTime dateRestition) {
		this.dateRestition = dateRestition;
	}

}
