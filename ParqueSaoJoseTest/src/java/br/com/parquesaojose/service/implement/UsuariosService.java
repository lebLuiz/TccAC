package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.repository.implement.UsuariosRepository;
import br.com.parquesaojose.service.interfaces.IUsuariosService;
import java.util.List;
import java.util.Objects;

public class UsuariosService implements IUsuariosService{

    @Override
    public Usuarios save(Usuarios usuarios) {
        
        UsuariosRepository repository = new UsuariosRepository();
        
        return repository.save(usuarios);
    }

    @Override
    public Usuarios update(Usuarios usuarios) {
        UsuariosRepository repository = new UsuariosRepository();
        
        return repository.update(usuarios);
    }

    @Override
    public void delete(Long idUsuarios) {
        UsuariosRepository repository = new UsuariosRepository();
        
        repository.delete(idUsuarios);
    }

    @Override
    public Usuarios findOne(Long idUsuarios) {
        UsuariosRepository repository = new UsuariosRepository();
        
        return repository.findOne(idUsuarios);
    }

    @Override
    public List<Usuarios> findAll() {
       UsuariosRepository repository = new UsuariosRepository();
       
       return repository.findAll();
    }

    @Override
    public Usuarios logar(String login, String senha) {
        
        UsuariosRepository repository = new UsuariosRepository();
       
       return repository.logar(login, senha);
    }
    
}
