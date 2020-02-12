package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Produtos;
import br.com.parquesaojose.repository.interfaces.IProdutosRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutosRepository implements IProdutosRepository{

    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";
    
    @Override
    public Produtos save(Produtos produtos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into produtos (id_empresa, ds_produto, vl_valor) values(?,?,?)");
        
            ps.setLong(1, produtos.getEmpresa().getIdEmpresa());
            ps.setString(2, produtos.getProduto());
            ps.setDouble(3, produtos.getValor());
            //ps.setBytes(4, produtos.getImagem());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutosRepository");
        }
        return produtos;
    }

    @Override
    public Produtos update(Produtos produtos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("update produtos set id_empresa=?, ds_produto=?, vl_valor=? where id_produto=?");
            
            ps.setLong(1, produtos.getEmpresa().getIdEmpresa());
            ps.setString(2, produtos.getProduto());
            ps.setDouble(3, produtos.getValor());
            //ps.setBytes(4, produtos.getImagem());
            
            ps.setLong(4, produtos.getIdProduto());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutosRepository");
        }
        return produtos;
    }

    @Override
    public void delete(Long idProdutos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from produtos where id_produto=?");
            
            ps.setLong(1, idProdutos);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutosRepository");
        }
    }

    @Override
    public Produtos findOne(Long idProdutos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutosRepository");
        }
        Produtos produtos = new Produtos();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_produto, id_empresa, ds_produto, vl_valor from produtos where id_produto=?");
            
            ps.setLong(1, idProdutos);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                produtos.setIdProduto(rs.getLong(1));
                produtos.getEmpresa().setIdEmpresa(rs.getLong(2));
                produtos.setProduto(rs.getString(3));
                produtos.setValor(rs.getDouble(4));
                //produtos.setImagem(rs.getBytes(5));
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ProdutosRepository");
        }
        return produtos;
    }

    @Override
    public List<Produtos> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ProdutosRepository");
        }
        List<Produtos> listaRetorno = new ArrayList();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_produto, id_empresa, ds_produto, vl_valor from produtos");
        
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Produtos produtos = new Produtos();
                
                produtos.setIdProduto(rs.getLong(1));
                produtos.getEmpresa().setIdEmpresa(rs.getLong(2));
                produtos.setProduto(rs.getString(3));
                produtos.setValor(rs.getDouble(4));
                //produtos.setImagem(rs.getBytes(5));
                
                listaRetorno.add(produtos);
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Coneão. Classe ProdutosRepository");
        }
        return listaRetorno;
    }
    
}
