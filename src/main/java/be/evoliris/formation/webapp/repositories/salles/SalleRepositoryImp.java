package be.evoliris.formation.webapp.repositories.salles;

import be.evoliris.formation.webapp.models.beans.salles.Salle;
import be.evoliris.formation.webapp.repositories.BaseRepository;

import javax.ejb.Stateless;
import javax.persistence.Query;

@Stateless
public class SalleRepositoryImp extends BaseRepository implements SalleRepository {

    @Override
    public Salle findByNom(String nom) {
        Query query = em.createQuery("SELECT s FROM Salle s WHERE s.nom = :nom");
        query.setParameter("nom", nom);
        return (Salle)query.getSingleResult();
    }

    @Override
    public Salle findById(Long id) {
        return null;
    }

    @Override
    public void insert(Salle obj) {

    }

    @Override
    public void update(Salle obj) {

    }
}
