/**
 * 
 */
package com.immobilier.agence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.immobilier.agence.model.ERole;
import com.immobilier.agence.model.Role;

/**
 * @author Boubacar
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	 Optional<Role> findByName(ERole name);
}
