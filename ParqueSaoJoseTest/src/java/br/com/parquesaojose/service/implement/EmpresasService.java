package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.repository.implement.EmpresasRepository;
import br.com.parquesaojose.service.interfaces.IEmpresasService;
import java.util.List;

public class EmpresasService implements IEmpresasService{

    @Override
    public Empresas save(Empresas empresa) {
        EmpresasRepository repository = new EmpresasRepository();
        
        return repository.save(empresa);
    }

    @Override
    public Empresas update(Empresas empresa) {
        EmpresasRepository repository = new EmpresasRepository();
        
        return repository.update(empresa);
    }

    @Override
    public void delete(Long idEmpresa) {
        EmpresasRepository repository = new EmpresasRepository();
        
        repository.delete(idEmpresa);
    }

    @Override
    public Empresas findOne(Long idEmpresa) {
        EmpresasRepository repository = new EmpresasRepository();
        
        return repository.findOne(idEmpresa);
    }

    @Override
    public List<Empresas> findAll() {
        EmpresasRepository repository = new EmpresasRepository();
        
        return repository.findAll();
    }

    @Override
    public Empresas findByIdUsuario(Long idUsuario) {
        EmpresasRepository repository = new EmpresasRepository();
        
        return repository.findByIdUsuario(idUsuario);
    }

    @Override
    public void deleteByIdUsuario(Long idUsuario) {
        EmpresasRepository repository = new EmpresasRepository();
        
        repository.deleteByIdUsuario(idUsuario);
    }
    
}
