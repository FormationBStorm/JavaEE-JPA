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
                System.out.println(value);
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                this.dateEmploie = LocalDate.parse(value);
                break;
            default: break;
        }
    }

    @Override
    public String toString() {
        return "Cadre{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", salaire=" + salaire +
                ", dateEmploie=" + dateEmploie +
                '}';
    }
}
