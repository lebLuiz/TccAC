package br.com.parquesaojose.service.interfaces;

import java.util.List;

public interface IService<T> {
    
    T save(T domain);
    T update(T domain);
    void delete(Long idDomain);
    T findOne(Long idDomain);
    List<T> findAll();
    
}
