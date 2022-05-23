/**
 * 
 */
package com.immobilier.agence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.immobilier.agence.model.Client;

/**
 * @author Boubacar
 *
 */
public interface RepositoryClient extends JpaRepository<Client, Long> {

}
