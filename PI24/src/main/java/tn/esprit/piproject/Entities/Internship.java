package tn.esprit.piproject.Entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
@Document(collection = "internships")

public class Internship {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int idCompany;
    private String duration;
    private String subject;
    private String description;
    private String degreeStageO;
    private TypeInternship Type;
}
