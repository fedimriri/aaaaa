package tn.esprit.piproject.Entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Document(collection = "companies")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idComp;

    private String nom;
    private String email;
private  String Description;
private  String Adresse;
private  Long NumTel;

}
