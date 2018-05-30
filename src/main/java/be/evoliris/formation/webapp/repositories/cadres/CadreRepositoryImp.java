package be.evoliris.formation.webapp.repositories.cadres;

import be.evoliris.formation.webapp.models.beans.personnels.Cadre;
import be.evoliris.formation.webapp.repositories.BaseRepository;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CadreRepositoryImp extends BaseRepository implements CadreRepository{
    @Override
    public List<Cadre> findByNom(String nom) {
        return null;
    }

    @Override
    public Cadre findById(Long id) {
        return null;
    }

    @Override
    public void update(Cadre obj) {

    }

    @Override
    public void insert(Cadre obj) {
        em.persist(obj);
        em.flush();
    }
}
