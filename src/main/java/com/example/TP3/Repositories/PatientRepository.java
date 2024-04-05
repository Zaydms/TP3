package com.example.TP3.Repositories;

import com.example.TP3.Entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    // Méthode pour rechercher des patients par leur nom
    Page<Patient> findByNomContaining(String nom, Pageable pageable);
}
