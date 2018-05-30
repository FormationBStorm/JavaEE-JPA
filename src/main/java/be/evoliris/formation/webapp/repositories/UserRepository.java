package be.evoliris.formation.webapp.repositories;

import be.evoliris.formation.webapp.models.User;

import javax.ejb.Remote;

@Remote
public interface UserRepository {
    User findById(Long id);
    void insert(User u);
}
