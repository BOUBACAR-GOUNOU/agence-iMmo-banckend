///**
// * 
// */
//package com.immobilier.agence.controllers;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//
///**
// * @author Boubacar
// *
// */
//public class UtilisateurController {
//
//	  
////	  /** Utlisateur**/
//  
//	  @Autowired
//	  private UtilisateurRepository utilisateurRepository;
//	  
//   @GetMapping(value = "/utilisateurs")
//	 public ResponseEntity<List<Utilisateur>>getAllUtilisateurs(@RequestParam(required = false) Long id){
//			try {
//				List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
//				if(id == null)
//					utilisateurRepository.findAll().forEach(utilisateurs::add);
//				else
//					utilisateurRepository.findByIdUtilisateur(id).forEach(utilisateurs::add);
//				
//				if(utilisateurs.isEmpty()) {
//					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//				}
//				return new ResponseEntity<>( utilisateurs, HttpStatus.OK);
//				
//			}catch (Exception e) {
//			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//			
//		}  
//	  
//		
////	  @GetMapping(value = "/utilisateurs")
////		public ResponseEntity<List<Utilisateur>>getAllUtilisateur(){
////			try {
////				List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
////				
////				utilisateurRepository.findAll().forEach(utilisateurs::add);
////				return new ResponseEntity<>(utilisateurs, HttpStatus.OK);
////				
////			}catch (Exception e) {
////			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
////		    }
////			
////		}
//	  
//	  
//		@GetMapping("/utilisateurs/{id}")
//		public ResponseEntity<Utilisateur> getUtilisateurById(@PathVariable("id") long id){
//			Optional<Utilisateur> utilisateurData = utilisateurRepository.findById(id);
//			if(utilisateurData.isPresent()) {
//				return new ResponseEntity<>(utilisateurData.get(), HttpStatus.OK);
//		    } else {
//		    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//			}
//		}
//	  
//	  @PostMapping("/utilisateurs")
//		 public ResponseEntity<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
//			try {	
//				utilisateur _utilisateur = utilisateurRepository.save(new Utilisateur(utilisateur.getNomUtilisateur(), utilisateur.getPrenomUtilisateur(), utilisateur.getEmailUtilisateur(), utilisateur.getMotPassUtilisateur()));  
//				return new ResponseEntity<>(_utilisateur, HttpStatus.CREATED);		
//			}catch (Exception e) {
//			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
//		    }
//		}
//		
//	  @PutMapping("/utilisateurs/{id}")
//	  public ResponseEntity<Utilisateur> updateUtilisateur(@PathVariable("id") long id, @RequestBody Utilisateur utilisateur) {
//	    Optional<Utilisateur> utilisateurData = utilisateurRepository.findById(id);
//	    
//	    if (utilisateurData.isPresent()) {
//	      Utilisateur _utilisateur = utilisateurData.get();
//	      _utilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
//	      _utilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
//	      _utilisateur.setEmailUtilisateur(utilisateur.getEmailUtilisateur());
//	      _utilisateur.setMotPassUtilisateur(utilisateur.getMotPassUtilisateur());
//	      return new ResponseEntity<>(utilisateurRepository.save(_utilisateur), HttpStatus.OK);
//	    } else {
//	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	    }
//	  }
//	  
//	  @DeleteMapping("/utilisateurs/{id}")
//	  public ResponseEntity<HttpStatus> deleteUtilisateur(@PathVariable("id") long id) {
//	    try {
//	      utilisateurRepository.deleteByidUtilisateur(id);
//	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//	    } catch (Exception e) {
//	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//	    }
//	  }
//	  
//
//}
