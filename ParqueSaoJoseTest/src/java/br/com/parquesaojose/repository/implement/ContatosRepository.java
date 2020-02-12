package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Contatos;
import br.com.parquesaojose.domain.Empresas;
import br.com.parquesaojose.domain.Usuarios;
import br.com.parquesaojose.repository.interfaces.IContatosRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatosRepository implements IContatosRepository{

    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";
    
    @Override
    public Contatos save(Contatos contatos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe ContatosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into contatos (id_empresa, tp_contato, ds_contato) values (?,?,?)");
            
            ps.setLong(1, contatos.getEmpresa().getIdEmpresa());
            ps.setString(2, contatos.getTipoContato());
            ps.setString(3, contatos.getContato());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ContatosRepository");
        }
        return contatos;
    }

    @Override
    public Contatos update(Contatos contatos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe Contatos Repository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("update contatos set id_empresa=?, tp_contato=?, ds_contato=? where id_contato=?");
            
            ps.setLong(1, contatos.getEmpresa().getIdEmpresa());
            ps.setString(2, contatos.getTipoContato());
            ps.setString(3, contatos.getContato());
            
            ps.setLong(4, contatos.getIdContato());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ContatosRepository");
        }
        return contatos;
    }

    @Override
    public void delete(Long idContatos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ContatosRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from contatos where id_contato=?");
            
            ps.setLong(1, idContatos);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ContatosRepository");
        }
    }

    @Override
    public Contatos findOne(Long idContatos) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ContatosRepository");
        }
        Contatos contatos = new Contatos();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_contato, id_empresa, tp_contato, ds_contato from contatos where id_contato=?");
            
            ps.setLong(1, idContatos);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                contatos.setIdContato(rs.getLong(1));
                contatos.getEmpresa().setIdEmpresa(rs.getLong(2));
                contatos.setTipoContato(rs.getString(3));
                contatos.setContato(rs.getString(4));
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ContatosRepository");
        }
        return contatos;
    }

    @Override
    public List<Contatos> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ContatosRepository");
        }
        List<Contatos> listaRetorno= new ArrayList();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_contato, id_empresa, tp_contato, ds_contato from contatos");
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Contatos contatos = new Contatos();
                
                contatos.setIdContato(rs.getLong(1));
                contatos.getEmpresa().setIdEmpresa(rs.getLong(2));
                contatos.setTipoContato(rs.getString(3));
                contatos.setContato(rs.getString(4));
                
                listaRetorno.add(contatos);
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Coneão. Classe ContatosRepository");
        }
        return listaRetorno;
    }

    @Override
    public Contatos findByIdEmpresa(Long idEmpresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe ContatosRepository");
        }
        Contatos contato = null;
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_contato, tp_contato, ds_contato, id_empresa from contatos where id_empresa=?");
        
            ps.setLong(1, idEmpresa);
  
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                
                contato = new Contatos();
                
                contato.setIdContato(rs.getLong(1));
                contato.setTipoContato(rs.getString(2));
                contato.setContato(rs.getString(3));
                
                Empresas empresa = new Empresas();
                empresa.setIdEmpresa(rs.getLong(4));
                
                contato.setEmpresa(empresa);
                
            }
            
            ps.execute();
            ps.close();
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe ContatosRepository");
        }
        return contato;
    }

    @Override
    public void deleteByIdEmpresa(Long idEmpresa) {
        
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe EmpresasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from contatos where id_empresa=?");
            
            ps.setLong(1, idEmpresa);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe EmpresasRepository");
        }
        
    }
    
}
