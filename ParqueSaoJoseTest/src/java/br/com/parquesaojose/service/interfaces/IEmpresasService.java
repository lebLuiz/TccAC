package br.com.parquesaojose.service.interfaces;

import br.com.parquesaojose.domain.Empresas;

public interface IEmpresasService extends IService<Empresas>{
    
    Empresas findByIdUsuario(Long idUsuario);
    
    void deleteByIdUsuario(Long idUsuario);
    
}
