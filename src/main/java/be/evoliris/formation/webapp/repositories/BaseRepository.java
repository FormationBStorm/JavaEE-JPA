package be.evoliris.formation.webapp.repositories;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseRepository {
    @PersistenceContext(unitName = "db")
    protected EntityManager em;
}
