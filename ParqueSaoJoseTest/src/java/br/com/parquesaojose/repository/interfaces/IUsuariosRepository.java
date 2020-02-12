package br.com.parquesaojose.repository.interfaces;

import br.com.parquesaojose.domain.Usuarios;

public interface IUsuariosRepository extends IRepository<Usuarios> {
    
    Usuarios logar(String login, String senha);
    
}
