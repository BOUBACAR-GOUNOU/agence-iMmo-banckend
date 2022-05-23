/**
 * 
 */
package com.immobilier.agence.model;



import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


/**
 * @author Boubacar
 *
 */

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	private String adresseClient;
	private String telephoneClient;
	private String nomClient;
	private String prenomClient;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	@JoinColumn(name = "BIEN_ID")
	private Bien bien;
	
	
	  @OneToOne(cascade = CascadeType.DETACH)
	  @JoinColumn(name = "idUser")
	  private User user;
	
	public Client() {
		super();
	}
	
	
	public Client(String adresseClient, String telephoneClient, String nomClient, String prenomClient) {
		
		super();
		this.adresseClient = adresseClient;
		this.telephoneClient =telephoneClient;
		this.nomClient = nomClient;
		this.prenomClient = prenomClient;
		
	}

	public String getAdresseClient() {
		return adresseClient;
	}

	public void setAdresseClient(String adresseClient) {
		this.adresseClient = adresseClient;
	}

	public String getTelephoneClient() {
		return telephoneClient;
	}

	public void setTelephoneClient(String telephoneClient) {
		this.telephoneClient = telephoneClient;
	}



	public Long getIdClient() {
		return idClient;
	}


	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Bien getBien() {
		return bien;
	}


	public void setBien(Bien bien) {
		this.bien = bien;
	}


	public String getNomClient() {
		return nomClient;
	}


	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}


	public String getPrenomClient() {
		return prenomClient;
	}


	public void setPrenomClient(String prenomClient) {
		this.prenomClient = prenomClient;
	}

}



