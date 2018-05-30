package be.evoliris.formation.webapp.models.beans;

import be.evoliris.formation.webapp.models.enums.CadreField;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class Cadre {
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private double salaire;
    private LocalDate dateEmploie;

    public void addField(CadreField field, String value){
        switch (field){
            case NOM:
                this.nom = value;
                break;
            case PRENOM:
                this.prenom = value;
                break;
            case ADRESSE:
                this.adresse = adresse;
                break;
            case SALAIRE:
                this.salaire = Double.parseDouble(value);
                break;
            case DATE_ENTRE_FONCTION:
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    this.dateEmploie = LocalDate.from(format.parse(value).toInstant());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            default: break;
        }
    }
}
