package be.evoliris.formation.webapp.repositories.salles;

import be.evoliris.formation.webapp.models.beans.salles.Salle;
import be.evoliris.formation.webapp.repositories.Repository;

import javax.ejb.Remote;

@Remote
public interface SalleRepository extends Repository<Salle> {
    Salle findByNom(String nom);
}
