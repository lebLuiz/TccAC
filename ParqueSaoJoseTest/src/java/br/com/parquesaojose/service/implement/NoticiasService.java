package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.Noticias;
import br.com.parquesaojose.repository.implement.NoticiasRepository;
import br.com.parquesaojose.service.interfaces.INoticiasService;
import java.util.List;

public class NoticiasService implements INoticiasService{

    @Override
    public Noticias save(Noticias noticias) {
        NoticiasRepository repository = new NoticiasRepository();
        
        return repository.save(noticias);
    }

    @Override
    public Noticias update(Noticias noticias) {
        NoticiasRepository repository = new NoticiasRepository();
        
        return repository.update(noticias);
    }

    @Override
    public void delete(Long idNoticias) {
        NoticiasRepository repository = new NoticiasRepository();
        
        repository.delete(idNoticias);
    }

    @Override
    public Noticias findOne(Long idNoticias) {
        NoticiasRepository repository = new NoticiasRepository();
        
        return repository.findOne(idNoticias);
    }

    @Override
    public List<Noticias> findAll() {
        NoticiasRepository repository = new NoticiasRepository();
        
        return repository.findAll();
    }
    
}
