/**
 * 
 */
package com.immobilier.agence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.immobilier.agence.model.Client;




/**
 * @author Boubacar
 *
 */
public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client>  findByIdClient(Long idClient);
	
	@Modifying
    @Transactional
	@Query(value = " DELETE FROM client WHERE id_client = ?1", nativeQuery = true)
	void deleteByIdClient(long idClient);

//	@Query(value = " SELECT * FROM client INNER JOIN bien ON client.bien_id = id_bien WHERE id_user = ?1", nativeQuery = true)
//	List<Client> findBienLouesByClient(long idUser);

	

//	@Query(value = " SELECT * FROM client INNER JOIN users ON client.id_user = users.id", nativeQuery = true)
	

}
