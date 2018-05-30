package be.evoliris.formation.webapp.repositories;

public interface Repository<T> {
    T findById(Long id);
    void update(T obj);
    void insert(T obj);
}
