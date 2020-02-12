package br.com.parquesaojose.service.interfaces;

import br.com.parquesaojose.domain.Usuarios;

public interface IUsuariosService extends IService<Usuarios> {
    
    Usuarios logar(String login, String senha);
    
}
