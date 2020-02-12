package br.com.parquesaojose.service.implement;

import br.com.parquesaojose.domain.Produtos;
import br.com.parquesaojose.repository.implement.ProdutosRepository;
import br.com.parquesaojose.service.interfaces.IProdutosService;
import java.util.List;

public class ProdutosService implements IProdutosService{

    @Override
    public Produtos save(Produtos produtos) {
        ProdutosRepository repository = new ProdutosRepository();
        
        return repository.save(produtos);
    }

    @Override
    public Produtos update(Produtos produtos) {
        ProdutosRepository repository = new ProdutosRepository();
        return repository.update(produtos);
    }

    @Override
    public void delete(Long idProdutos) {
        ProdutosRepository repository = new ProdutosRepository();
        
        repository.delete(idProdutos);
    }

    @Override
    public Produtos findOne(Long idProdutos) {
        ProdutosRepository repository = new ProdutosRepository();
        
        return repository.findOne(idProdutos);
    }

    @Override
    public List<Produtos> findAll() {
        ProdutosRepository repository = new ProdutosRepository();
        
        return repository.findAll();
    }
    
}
