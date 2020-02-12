package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.EmpresasT;
import br.com.parquesaojose.repository.implement.EmpresasTRepository;
import br.com.parquesaojose.service.interfaces.IEmpresasTService;
import java.util.List;

public class EmpresasTService implements IEmpresasTService{

    @Override
    public EmpresasT save(EmpresasT empresa) {
        EmpresasTRepository repository = new EmpresasTRepository();
        
        return repository.save(empresa);
    }

    @Override
    public EmpresasT update(EmpresasT empresa) {
        EmpresasTRepository repository = new EmpresasTRepository();
        
        return repository.update(empresa);
    }

    @Override
    public void delete(Long idEmpresa) {
        EmpresasTRepository repository = new  EmpresasTRepository();
        
        repository.delete(idEmpresa);
    }

    @Override
    public EmpresasT findOne(Long idEmpresa) {
        EmpresasTRepository repository = new EmpresasTRepository();
        
        return repository.findOne(idEmpresa);
    }

    @Override
    public List<EmpresasT> findAll() {
        EmpresasTRepository repository = new EmpresasTRepository();
        
        return repository.findAll();
    }
    
}
