package br.com.parquesaojose.repository.interfaces;

import br.com.parquesaojose.domain.Contatos;
import br.com.parquesaojose.domain.Empresas;

public interface IContatosRepository extends IRepository<Contatos>{
    
    Contatos findByIdEmpresa(Long idEmpresa);
    
    void deleteByIdEmpresa(Long idEmpresa);
    
}
