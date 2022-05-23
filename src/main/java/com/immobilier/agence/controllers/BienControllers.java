/**
 * 
 */
package com.immobilier.agence.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.agence.model.Bien;
import com.immobilier.agence.model.Categorie;
import com.immobilier.agence.repository.BienRepository;
import com.immobilier.agence.repository.CategorieRepository;

/**
 * @author Boubacar
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bien")
public class BienControllers {

	@Autowired
	private BienRepository bienRepository;
	
	@Autowired
	private CategorieRepository categorieRepository;
	
	@Value("${cautionLocation}")
	private String cautionLocation;
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping(value = "/list")
	public ResponseEntity<List<Bien>>getAllBiens(){
		try {
			List<Bien> biens = bienRepository.findAll();
			return new ResponseEntity<>(biens, HttpStatus.OK);
			
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
	}
 

	@GetMapping(value = "/location")
	public ResponseEntity<List<Bien>>getLocation(){
		try {
			List<Bien> biens = 	bienRepository.findBystatutBien("location");
			return new ResponseEntity<>( biens, HttpStatus.OK);
			
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
	}
 
	
	@GetMapping(value = "/vente")
	public ResponseEntity<List<Bien>>getVente(){
		try {
			List<Bien> biens = 	bienRepository.findBystatutBien("VENTE");
			return new ResponseEntity<>( biens, HttpStatus.OK);
			
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }	
	}
	
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@GetMapping("details/{id}")
	public ResponseEntity<Bien> getBienById(@PathVariable("id") long id){
		Optional<Bien> bienData = bienRepository.findById(id);
		if(bienData.isPresent()) {
			return new ResponseEntity<>(bienData.get(), HttpStatus.OK);
	    } else {
	    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	@PostMapping("/ad")
	 public ResponseEntity<Bien> createBien(@RequestBody Bien bien) {
		
	 Bien _bien = new Bien(bien.getDescriptionBien(), bien.getImageBien(), bien.getPrixBien(), bien.getQuantiteBien(), bien.getLocalisationBien(), bien.getStatutBien());               

		try {
			 if(bien.getCategorie()!=null && bien.getCategorie().getIdCategorie()!=null)
	         {
	        	  List<Categorie> categories = categorieRepository.findCategorieById(bien.getCategorie().getIdCategorie());
	              _bien.setCategorie(categories.get(0));
	         }
	         
			 _bien = bienRepository.save(_bien);
			 
			 return new ResponseEntity<>(_bien, HttpStatus.CREATED);	
			 
		}catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
	
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @PutMapping("/update/{id}")
	  public ResponseEntity<Bien> updateBien(@PathVariable("id") long id, @RequestBody Bien bien) {
	    Optional<Bien> bienData = bienRepository.findById(id);

	    if (bienData.isPresent()) {
	      Bien _bien = bienData.get();
	      _bien.setDescriptionBien(bien.getDescriptionBien());
	      _bien.setImageBien(bien.getImageBien()); 
	      _bien.setPrixBien(bien.getPrixBien());
	      _bien.setQuantiteBien(bien.getQuantiteBien());
	      _bien.setLocalisationBien(bien.getLocalisationBien());
	      _bien.setStatutBien(bien.getStatutBien());
	      _bien.setCategorie(bien.getCategorie());
	      return new ResponseEntity<>(bienRepository.save(_bien), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  

	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @DeleteMapping("delete/{id}")
	  public ResponseEntity<HttpStatus> deleteBiens(@PathVariable("id") long id) {
	    try {
	      bienRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @GetMapping(value = "/caution")
	  public ResponseEntity<?>getCaution(){
			try {

				return new ResponseEntity<>( cautionLocation, HttpStatus.OK);
				
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
		}

	  @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	  @GetMapping("/categorie")
		public ResponseEntity<List<Categorie>> getCategorie(){
		  try {
				List<Categorie> categories = categorieRepository.findAll();
				return new ResponseEntity<>( categories, HttpStatus.OK);
				
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }	
		}
	  
	  
	 

}
