package be.evoliris.formation.webapp.models.beans.personnels;

import be.evoliris.formation.webapp.models.enums.CadreField;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personnel {
    @Id
    @Column(name = "pers_id") @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    private String prenom;
    private String adresse;
    private double salaire;
    private LocalDate dateEmploie;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public LocalDate getDateEmploie() {
        return dateEmploie;
    }

    public void setDateEmploie(LocalDate dateEmploie) {
        this.dateEmploie = dateEmploie;
    }


    public void addField(CadreField field, String value){
        switch (field){
            case NOM:
                this.setNom(value);
                break;
            case PRENOM:
                this.setPrenom(value);
                break;
            case ADRESSE:
                if(value.equals(""))this.setAdresse(null);
                else this.setAdresse(value);
                break;
            case SALAIRE:
                this.setSalaire(Double.parseDouble(value));
                break;
            case DATE_ENTRE_FONCTION:
                System.out.println(value);
                this.setDateEmploie(LocalDate.parse(value));
                break;
            default: break;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personnel personnel = (Personnel) o;
        return Objects.equals(id, personnel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, adresse, salaire, dateEmploie);
    }

    @Override
    public String toString() {
        return "Personnel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", salaire=" + salaire +
                ", dateEmploie=" + dateEmploie +
                '}';
    }
}
