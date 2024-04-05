package com.example.TP3;

import com.example.TP3.Entities.Patient;
import com.example.TP3.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.List;


@SpringBootApplication
public class TP3Application implements CommandLineRunner {

    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(TP3Application.class, args);
    }

    @Override
    public void run(String... args) {
        // Création de quelques patients et sauvegarde dans la base de données
        patientRepository.save(new Patient(null, "bdich", new Date(), true, 600));
        patientRepository.save(new Patient(null, "talon", new Date(), false, 905));
        patientRepository.save(new Patient(null, "kenyo", new Date(), false, 1000));
        patientRepository.save(new Patient(null, "seik", new Date(), true, 500));
        List<Patient> Patients = patientRepository.findAll();
        for (var e : Patients) {
            System.out.println(e);
        }
        ;
    }
}

