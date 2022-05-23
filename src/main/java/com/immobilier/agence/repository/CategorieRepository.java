/**
 * 
 */
package com.immobilier.agence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.immobilier.agence.model.Categorie;

/**
 * @author Boubacar
 *
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {

	@Query(value = "SELECT * FROM categorie  WHERE nom_categorie = ?1", nativeQuery = true)
	List<Categorie> findByName(String nom);

	 @Query(value = "SELECT * FROM categorie  WHERE id_categorie = ?1", nativeQuery = true)
	List<Categorie> findCategorieById(Long idCategorie);

}
