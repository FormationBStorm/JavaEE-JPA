package be.evoliris.formation.webapp.repositories;

import be.evoliris.formation.webapp.models.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class UserRepositoryImp implements UserRepository {
    @PersistenceContext(unitName = "db")
    private EntityManager em;

    @Override
    public User findById(Long id) {
        Query query = em.createQuery("SELECT u FROM User u WHERE u.id = :id");
        query.setParameter("id", id);

        return (User)query.getSingleResult();
    }

    @Override
    public void insert(User u) {
        em.persist(u);
        em.flush();
    }
}
