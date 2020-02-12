package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.Contatos;
import br.com.parquesaojose.repository.implement.ContatosRepository;
import br.com.parquesaojose.service.interfaces.IContatosService;
import java.util.List;

public class ContatosService implements IContatosService{

    @Override
    public Contatos save(Contatos contato) {
        ContatosRepository repository = new ContatosRepository();
        
        return repository.save(contato);
    }
    
    @Override
    public Contatos update(Contatos contato) {
        ContatosRepository repository = new ContatosRepository();
        
        return repository.update(contato);
    }

    @Override
    public void delete(Long idContato) {
        ContatosRepository repository = new ContatosRepository();
        
        repository.delete(idContato);
    }

    @Override
    public Contatos findOne(Long idContato) {
        ContatosRepository repository = new ContatosRepository();
        
        return repository.findOne(idContato);
    }

    @Override
    public List<Contatos> findAll() {
        ContatosRepository repository = new ContatosRepository();
        
        return repository.findAll();
    }

    @Override
    public Contatos findByIdEmpresa(Long idEmpresa) {
        ContatosRepository repository = new ContatosRepository();
        
        return repository.findByIdEmpresa(idEmpresa);
    }

    @Override
    public void deleteByIdEmpresa(Long idEmpresa) {
        ContatosRepository repository = new ContatosRepository();
        
        repository.deleteByIdEmpresa(idEmpresa);
    }
    
}
