package be.evoliris.formation.webapp.models.beans.personnels;

import be.evoliris.formation.webapp.models.beans.personnels.Personnel;
import be.evoliris.formation.webapp.models.beans.salles.Salle;
import be.evoliris.formation.webapp.models.enums.CadreField;

import javax.ejb.EJB;
import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

@Entity
public class Cadre extends Personnel {

    @OneToOne(targetEntity = Salle.class, fetch = FetchType.EAGER, optional = true)
    @JoinColumn(name = "cadre_bureau")
    private Salle bureau;

    public Cadre() {
    }

    public Salle getBureau() {
        return bureau;
    }

    public void setBureau(Salle bureau) {
        this.bureau = bureau;
    }

    @Override
    public void addField(CadreField field, String value) {
        super.addField(field, value);
    }
    public void addField(CadreField field, Salle salle){
        this.bureau = salle;
    }

    @Override
    public String toString() {
        return "personnels{personnel= '"+ super.toString()+ "}";
    }
}
