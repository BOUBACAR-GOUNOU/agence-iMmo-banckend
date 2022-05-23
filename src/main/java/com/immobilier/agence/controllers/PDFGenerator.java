/**
 * 
 */
package com.immobilier.agence.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;


import com.immobilier.agence.model.Client;

/**
 * @author Boubacar
 *
 */

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class PDFGenerator {

	 @Autowired
	 ServletContext servletContext;

	 	    private final TemplateEngine templateEngine;

	 	    public PDFGenerator(TemplateEngine templateEngine) {
	 	        this.templateEngine = templateEngine;
	 	    }

	 @RequestMapping(path = "bordereau/{id}/pdf")
	     public ResponseEntity<?> getPDF(@PathVariable("id") Long id, HttpServletRequest request, HttpServletResponse response) throws IOException {

	         /* Do Business Logic*/

	        // Louer order = louerRepo.Bordereau(id);
	    
	         /* Create HTML using Thymeleaf template Engine */
	     	try {

	         WebContext context = new WebContext(request, response, servletContext);
	         context.setVariable("id", id);
	         context.setVariable("orderEntry", order);
	         String orderHtml = templateEngine.process("order", context);
	        
	         /* Setup Source and target I/O streams */

	         ByteArrayOutputStream target = new ByteArrayOutputStream();
	         ConverterProperties converterProperties = new ConverterProperties();
	         
	         converterProperties.setBaseUri("http://localhost:8080");
	         
	         /* Call convert method */
	         HtmlConverter.convertToPdf(orderHtml, target, converterProperties);
	         
	         /* extract output as bytes */
	         byte[] bytes = target.toByteArray();

	        
	         /* Send the response as downloadable PDF */

	         return ResponseEntity.ok()
	                 .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=order.pdf")
	                 .contentType(MediaType.APPLICATION_PDF)
	                 .body(bytes);
	     	}catch(Exception e) {
	     	
	     		return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
	     	}

	     }


	 }
