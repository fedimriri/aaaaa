package tn.esprit.piproject.Entities;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "defences")
public class Defence {

    private int idDef;
    private static int idCounter = 0;

    public Defence() {

        this.idDef = ++idCounter;
    }

    public int getIdDef() {
        return idDef;
    }

    public void setIdDef(int idDef) {
        this.idDef = idDef;
    }
}
