package be.evoliris.formation.webapp.repositories.cadres;

import be.evoliris.formation.webapp.models.beans.personnels.Cadre;
import be.evoliris.formation.webapp.repositories.Repository;

import javax.ejb.Remote;
import java.util.List;

@Remote
public interface CadreRepository extends Repository<Cadre> {
    List<Cadre> findByNom(String nom);
}
