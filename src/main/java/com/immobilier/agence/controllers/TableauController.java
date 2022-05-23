package com.immobilier.agence.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/tableau")
public class TableauController {
  @GetMapping("/all")
  public String allAccess() {
    return "Public Content.";
  }

  @GetMapping("/user")
  @PreAuthorize("hasRole('USER')  or hasRole('ADMIN')")
  public String userAccess() {
    return "Affichage d'utilisateur.";
  }

//  @GetMapping("/mod")
//  @PreAuthorize("hasRole('MODERATOR')")
//  public String moderatorAccess() {
//    return "Tableau de moderateur.";
//  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ADMIN')")
  public String adminAccess() {
    return "Admin.";
  }
}
