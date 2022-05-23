/**
 * 
 */
package com.immobilier.agence.controllers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.agence.model.Bien;
import com.immobilier.agence.model.Location;
import com.immobilier.agence.model.User;
import com.immobilier.agence.repository.BienRepository;
import com.immobilier.agence.repository.LocationRepository;
import com.immobilier.agence.repository.UserRepository;

/**
 * @author Boubacar
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/location")
public class LocationController {

	
	     @Autowired
	     private LocationRepository locationRepository;
	     
	     @Autowired
	     private BienRepository bienRepository;
	     
	     @Autowired
	     private UserRepository userRepository;
	 
		
		 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		 @PostMapping("/ad")
		 public ResponseEntity<Location> createLocation(@RequestBody Location location) {

	   try { 
	         Location _location = new Location(location.getCautionLocation(), location.getDureBail()); 
	         
	         if(location.getUser()!=null && location.getUser().getUsername() !=null)
	         {
	        	  List<User> users = userRepository.findAllByUsername(location.getUser().getUsername());
	              _location.setUser(users.get(0));
	          }
	         
	         if(location.getBien()!=null && location.getBien().getIdBien() !=null)
	         {
	        	  List<Bien> biens = bienRepository.findBienById(location.getBien().getIdBien());
	              _location.setBien(biens.get(0));
	         }
	         
	           _location = locationRepository.save(_location);
	           
	         return new ResponseEntity<>(_location, HttpStatus.CREATED);   
	         
	         }catch (Exception e) {
	            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	        }
		 }
		 
		 @GetMapping(value = "/compte")
		 public String nombreLocation() {
			    return  locationRepository.countBienNonRestiuer();
		}
		 
		 @GetMapping(value = "/compteBienRestituer")
		 public String nombreLocationRestiuer() {
			    return  locationRepository.countBienRestiuer();
		}
		 
		 
		 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		 @GetMapping("/biensLoues/{idUser}")
		 public ResponseEntity<List<Location>> getBiensLoues(@PathVariable("idUser") long idUser){
		 try {
				List<Location> locations = locationRepository.findBienLouesByClient(idUser);
				return new ResponseEntity<>( locations, HttpStatus.OK);
				
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
		}
		 
		 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		 @GetMapping("/biensRestitues/{idUser}")
		 public ResponseEntity<List<Location>> getBiensRestitues(@PathVariable("idUser") long idUser){
		 try {
				List<Location> locations = locationRepository.findBienRestituesByClient(idUser);
				return new ResponseEntity<>( locations, HttpStatus.OK);
				
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
		}
		 
		
		 @GetMapping(value = "/compteBiensLouesByClient/{idUser}")
		 public String nombreBiensLouesByClient(@PathVariable("idUser") long idUser) {
			    return  locationRepository.countBienLouesByClient(idUser);
		}
		 
		 
		 @GetMapping(value = "/compteBienRestituerByClient/{idUser}")
		 public String nombreBiensRestiuesByClient(@PathVariable("idUser") long idUser) {
			    return  locationRepository.countBienRestituesByClient(idUser);
		}
		
		 
		  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
		  @PutMapping("/restituer/{id}")
		  public ResponseEntity<Location> restituerBien(@PathVariable("id") long id, @RequestBody Location locationBien) {
		   Optional<Location> bienLocationData = locationRepository.findById(id);

		    if (bienLocationData.isPresent()) {
		    
		      Location _location = bienLocationData.get();
		      boolean var = LocalDate.now().isAfter(_location.getDateLocation().plusDays(_location.getDureBail())) ;
		      if(var)
		      {
		    	  _location.setPenalite(_location.getCautionLocation());
		      }
		      
		     _location.setRestituerBien(true);
		     _location.setDateRestitution(LocalDate.now());
		      return new ResponseEntity<>(locationRepository.save(_location), HttpStatus.OK);
		    } else {
		      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		    }
		  }
}
