/**
 * 
 */
package com.immobilier.agence.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.immobilier.agence.model.Bien;
import com.immobilier.agence.model.Client;
import com.immobilier.agence.model.User;
import com.immobilier.agence.repository.BienRepository;
import com.immobilier.agence.repository.ClientRepository;
import com.immobilier.agence.repository.UserRepository;

/**
 * @author Boubacar
 *
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/clients")
public class ClientController {
	

	 @Autowired
	 private ClientRepository clientRepository;
	 
	 @Autowired
	 private UserRepository userRepository;
	 
	 @Autowired
	 private BienRepository bienRepository;
	 
	 @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
     @GetMapping(value = "/list")
	 public ResponseEntity<List<Client>>getAllClients(@RequestParam(required = false) Long id){
			try {
				List<Client> clients = new ArrayList<Client>();
				if(id == null)
					clientRepository.findAll().forEach(clients::add);
				else
					clientRepository.findByIdClient(id).forEach(clients::add);
				
				if(clients.isEmpty()) {
					return new ResponseEntity<>(HttpStatus.NO_CONTENT);
				}
				
				return new ResponseEntity<>( clients, HttpStatus.OK);
				
			}catch (Exception e) {
			      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
			
		}  
	  
	  @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
		@GetMapping("details/{id}")
		public ResponseEntity<Client> getClientById(@PathVariable("id") long id){
			Optional<Client> clientData = clientRepository.findById(id);
			if(clientData.isPresent()) {
				return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		    } else {
		    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	  
	 @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
	 @PostMapping("/ad")
	 public ResponseEntity<Client> createClient(@RequestBody Client client) {

   try { 
         Client _client = new Client(client.getAdresseClient(), client.getTelephoneClient(), client.getNomClient(), client.getPrenomClient()); 
         if(client.getUser()!=null && client.getUser().getUsername() !=null)
         {
        	  List<User> users = userRepository.findAllByUsername(client.getUser().getUsername());
              _client.setUser(users.get(0));
          }
         
         if(client.getBien()!=null && client.getBien().getIdBien() !=null)
         {
        	  List<Bien> biens = bienRepository.findBienById(client.getBien().getIdBien());
              _client.setBien(biens.get(0));
         }
         
           _client = clientRepository.save(_client);
           
         return new ResponseEntity<>(_client, HttpStatus.CREATED);   
         
         }catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
	 }
	 
		
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @PutMapping("/{id}")
	  public ResponseEntity<Client> updateClient(@PathVariable("id") long id, @RequestBody Client client) {
	    Optional<Client> clientData = clientRepository.findById(id);
	    
	    if (clientData.isPresent()) {
	      Client _client = clientData.get();
	      _client.setAdresseClient(client.getAdresseClient());
	      _client.setTelephoneClient(client.getTelephoneClient());
	    //  _client.setUtilisateur(client.getUtilisateur());
	      return new ResponseEntity<>(clientRepository.save(_client), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @DeleteMapping("/{id}")
	  public ResponseEntity<HttpStatus> deleteClient(@PathVariable("id") long id) {
	    try {
	      clientRepository.deleteByIdClient(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	  }
	  
	  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	  @GetMapping(value = "/compte")
	  public long nombreClient() {
		  
		    return  clientRepository.count();
	  }
	  
	  
}
