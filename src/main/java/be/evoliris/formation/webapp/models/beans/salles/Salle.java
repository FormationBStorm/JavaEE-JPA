package be.evoliris.formation.webapp.models.beans.salles;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class Salle implements Serializable {
    @Id @Column(name = "salle_id") @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Salle salle = (Salle) o;
        return Objects.equals(id, salle.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom);
    }

    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }
}
