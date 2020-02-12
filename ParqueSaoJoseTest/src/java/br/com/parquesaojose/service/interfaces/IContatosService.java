package br.com.parquesaojose.service.interfaces;

import br.com.parquesaojose.domain.Contatos;

public interface IContatosService extends IService<Contatos>{
    
    Contatos findByIdEmpresa(Long idEmpresa);
    
    void deleteByIdEmpresa(Long idEmpresa);
    
}
