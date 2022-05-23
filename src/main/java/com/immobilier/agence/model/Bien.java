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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;



/**
 * @author Boubacar
 *
 */

@Entity
public class Bien {
   
	@Id
	@GeneratedValue
	private Long idBien;
	private String descriptionBien;
	@Lob
	private String imageBien;
	private double prixBien;
	private int quantiteBien;
	private String localisationBien;
	@CreationTimestamp
	private LocalDate dateEnregistre;
	private String statutBien;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JoinColumn(name = "CATEGORIE_ID")
	private Categorie categorie;
	
	
	
	
	public Bien() {
		super();
	}
	
	public Bien( String descriptionBien, String imageBien, double prixBien ,int quantiteBien, String localisationBien, String statutBien) {
		
		super();
		this.descriptionBien = descriptionBien;
		this.setImageBien(imageBien);
		this.prixBien = prixBien;
		this.quantiteBien = quantiteBien;
		this.localisationBien = localisationBien;
		this.setStatutBien(statutBien);
	}

	public Long getIdBien() {
		return idBien;
	}

	public void setIdBien(Long idBien) {
		this.idBien = idBien;
	}

	public String getDescriptionBien() {
		return descriptionBien;
	}

	public void setDescriptionBien(String descriptionBien) {
		this.descriptionBien = descriptionBien;
	}



	public double getPrixBien() {
		return prixBien;
	}

	public void setPrixBien(double prixBien) {
		this.prixBien = prixBien;
	}

	public int getQuantiteBien() {
		return quantiteBien;
	}

	public void setQuantiteBien(int quantiteBien) {
		this.quantiteBien = quantiteBien;
	}

	public String getLocalisationBien() {
		return localisationBien;
	}

	public void setLocalisationBien(String localisationBien) {
		this.localisationBien = localisationBien;
	}

	public LocalDate getDateEnregistre() {
		return dateEnregistre;
	}

	public void setDateEnregistre(LocalDate dateEnregistre) {
		this.dateEnregistre = dateEnregistre;
	}


	public String getImageBien() {
		return imageBien;
	}

	public void setImageBien(String imageBien) {
		this.imageBien = imageBien;
	}


	public String getStatutBien() {
		return statutBien;
	}

	public void setStatutBien(String statutBien) {
		this.statutBien = statutBien;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

//	public Payement getPayement() {
//		return payement;
//	}
//
//	public void setPayement(Payement payement) {
//		this.payement = payement;
//	}


	
}
