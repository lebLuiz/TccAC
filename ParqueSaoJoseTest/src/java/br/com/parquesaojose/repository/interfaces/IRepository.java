package br.com.parquesaojose.repository.interfaces;

import java.util.List;

public interface IRepository<T> {
    
    T save(T domain);
    T update(T domain);
    void delete(Long idDomain);
    T findOne(Long idDomain);
    List<T> findAll();
    
}
