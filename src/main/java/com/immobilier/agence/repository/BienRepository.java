/**
 * 
 */
package com.immobilier.agence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.immobilier.agence.model.Bien;



/**
 * @author Boubacar
 *
 */


public interface BienRepository extends JpaRepository<Bien, Long> {


	@Query(value = "SELECT * FROM bien  WHERE statut_bien = ?1", nativeQuery = true)
	public List<Bien>  findBystatutBien(String statutBien);
	
    
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM `agence`.`bien` WHERE  `id_bien`=?1", nativeQuery = true)
	void deleteByidBien(int idBien);

    @Query(value = "SELECT * FROM bien  WHERE id_bien = ?1", nativeQuery = true)
	public List<Bien> findBienById(Long idBien);




  

    
	

   
	
}
