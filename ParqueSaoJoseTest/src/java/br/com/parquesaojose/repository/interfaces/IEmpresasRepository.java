package br.com.parquesaojose.repository.interfaces;

import br.com.parquesaojose.domain.Empresas;

public interface IEmpresasRepository extends IRepository<Empresas>{

    Empresas findByIdUsuario(Long idUsuario);
    
    void deleteByIdUsuario(Long idUsuario);
    
}
