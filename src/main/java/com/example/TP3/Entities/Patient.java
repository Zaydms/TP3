package com.example.TP3.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 @NotEmpty
 @Size(min = 3, max = 20)
 private String nom;
 @Temporal(TemporalType.DATE)
 @DateTimeFormat(pattern = "dd-MM-yyyy")
 private Date dateNaissance;
 private boolean malade;
 @DecimalMin("100")
 private int score;

 // Méthode toString pour afficher les informations du patient
 @Override
 public String toString() {
  return "Patient{" +
          "id=" + id +
          ", nom='" + nom + '\'' +
          ", dateNaissance=" + dateNaissance +
          ", malade=" + malade +
          ", score=" + score +
          '}';
 }
}
