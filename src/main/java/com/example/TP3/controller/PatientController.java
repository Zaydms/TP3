package com.example.TP3.controller;

import com.example.TP3.Entities.Patient;
import com.example.TP3.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientRepository patientRepository;

    // Afficher tous les patients avec pagination
    @GetMapping("/all")
    public String getAllPatients(Model model, Pageable pageable) {
        Page<Patient> patients = patientRepository.findAll(pageable);
        model.addAttribute("patients", patients);
        return "patients";
    }

    // Rechercher des patients par nom
    @GetMapping("/search")
    public String searchPatients(Model model, @RequestParam("keyword") String keyword, Pageable pageable) {
        Page<Patient> patients = patientRepository.findByNomContaining(keyword, pageable);
        model.addAttribute("patients", patients);
        return "patients";
    }

    // Supprimer un patient
    @GetMapping("/delete/{id}")
    public String deletePatient(@PathVariable("id") Long id) {
        patientRepository.deleteById(id);
        return "redirect:/patients/all";
    }
}
