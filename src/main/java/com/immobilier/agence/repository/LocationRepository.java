/**
 * 
 */
package com.immobilier.agence.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.immobilier.agence.model.Location;

/**
 * @author Boubacar
 *
 */
public interface LocationRepository extends JpaRepository<Location, Long>{

	
	   @Query(value = "SELECT COUNT(*) FROM location WHERE restituer_bien = 0", nativeQuery = true)
	   public String countBienNonRestiuer();
	   
	   @Query(value = "SELECT COUNT(*) FROM location WHERE restituer_bien = 1", nativeQuery = true)
	   public String countBienRestiuer();

	   @Query(value = " SELECT * FROM location INNER JOIN  bien WHERE location.bien_id = bien.id_bien AND  restituer_bien = 0 AND id_user = ?1", nativeQuery = true)
	   public List<Location> findBienLouesByClient(long idUser);
	   
	   @Query(value = " SELECT * FROM location INNER JOIN  bien WHERE location.bien_id = bien.id_bien AND  restituer_bien = 1 AND id_user = ?1", nativeQuery = true)
	   public List<Location> findBienRestituesByClient(long idUser);
	   
	   @Query(value = " SELECT COUNT(*) FROM location INNER JOIN  bien WHERE location.bien_id = bien.id_bien AND  restituer_bien = 0 AND id_user = ?1", nativeQuery = true)
	   public String countBienLouesByClient(long idUser);
	   
	   @Query(value = " SELECT COUNT(*) FROM location INNER JOIN  bien WHERE location.bien_id = bien.id_bien AND  restituer_bien = 1 AND id_user = ?1", nativeQuery = true)
	   public String countBienRestituesByClient(long idUser);
	   
	
}
