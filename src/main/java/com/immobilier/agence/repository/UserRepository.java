/**
 * 
 */
package com.immobilier.agence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.immobilier.agence.model.User;

/**
 * @author Boubacar
 *
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);

  Boolean existsByUsername(String username);

  Boolean existsByEmail(String email);

  @Query(value = "SELECT * FROM users  WHERE username = ?1", nativeQuery = true)
  public List<User> findAllByUsername(String username);
}
