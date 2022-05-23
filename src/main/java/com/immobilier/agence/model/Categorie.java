/**
 * 
 */
package com.immobilier.agence.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Boubacar
 *
 */

@Entity
public class Categorie {

	@Id
	@GeneratedValue
	private Long idCategorie;
	private String nomCategorie;
	
	 
	public Categorie() {
		super();
	}
	
	public Categorie(String nomCategorie) {
		super();
		this.nomCategorie = nomCategorie;
	}


	public String getNomCategorie() {
		return nomCategorie;
	}

	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
	}

	public Long getIdCategorie() {
		return idCategorie;
	}

	public void setIdCategorie(Long idCategorie) {
		this.idCategorie = idCategorie;
	}

}
