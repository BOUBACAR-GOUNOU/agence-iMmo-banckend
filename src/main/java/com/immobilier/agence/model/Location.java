/**
 * 
 */
package com.immobilier.agence.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * @author Boubacar
 *
 */
@Entity
public class Location {

	@Id
	@GeneratedValue
	private Long idLocation;
	private double cautionLocation;
	@CreationTimestamp
	private LocalDate dateLocation;
	private int dureBail;
	private  boolean restituerBien = false;
	private  LocalDate dateRestitution;
	private double penalite = 0 ;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "BIEN_ID")
	private Bien bien;
	
	 @OneToOne(cascade = CascadeType.DETACH)
	 @JoinColumn(name = "idUser")
	 private User user;
	 
	
	public Location() {
		super();
	}
	
	public Location( double cautionLocation, int dureBail)
	{
		this.setCautionLocation(cautionLocation);
		this.dureBail = dureBail;
	}

	public LocalDate getDateLocation() {
		return dateLocation;
	}

	public void setDateLocation(LocalDate dateLocation) {
		this.dateLocation = dateLocation;
	}

	public Long getIdLocation() {
		return idLocation;
	}

	public void setIdLocation(Long idLocation) {
		this.idLocation = idLocation;
	}


	public Bien getBien() {
		return bien;
	}

	public void setBien(Bien bien) {
		this.bien = bien;
	}

	public double getCautionLocation() {
		return cautionLocation;
	}

	public void setCautionLocation(double cautionLocation) {
		this.cautionLocation = cautionLocation;
	}

	public boolean isRestituerBien() {
		return restituerBien;
	}

	public void setRestituerBien(boolean restituerBien) {
		this.restituerBien = restituerBien;
	}

	public int getDureBail() {
		return dureBail;
	}

	public void setDureBail(int dureBail) {
		this.dureBail = dureBail;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LocalDate getDateRestitution() {
		return dateRestitution;
	}

	public void setDateRestitution(LocalDate dateRestitution) {
		this.dateRestitution = dateRestitution;
	}

	public double getPenalite() {
		return penalite;
	}

	public void setPenalite(double penalite) {
		this.penalite = penalite;
	}

}
