package br.com.parquesaojose.repository.implement;

import br.com.parquesaojose.domain.Noticias;
import br.com.parquesaojose.repository.interfaces.INoticiasRepository;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class NoticiasRepository implements INoticiasRepository{

    private final String url = "jdbc:postgresql://localhost:5432/parque_sao_jose";
    private final String user = "postgres";
    private final String password = "postgres";
    
    @Override
    public Noticias save(Noticias noticias) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Econtrado. Classe NoticiasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("insert into noticias (id_empresa, ds_titulo, dt_publicacao, ds_noticia) values (?,?,?,?)");
        
            ps.setLong(1, noticias.getEmpresa().getIdEmpresa());
            ps.setString(2, noticias.getTitulo());
            ps.setObject(3, noticias.getDataPublicacao());
            ps.setString(4, noticias.getNoticia());
            //ps.setBytes(5, noticias.getImagem());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe NoticiasRepository");
        }
        return noticias;
    }

    @Override
    public Noticias update(Noticias noticias) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Econtrado. Classe NoticiasRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("update noticias set id_empresa=?, ds_titulo=?, dt_publicacao=?, ds_noticia=? where id_noticia=?");
        
            ps.setLong(1, noticias.getEmpresa().getIdEmpresa());
            ps.setString(2, noticias.getTitulo());
            ps.setObject(3, noticias.getDataPublicacao());
            ps.setString(4, noticias.getNoticia());
            //ps.setBytes(5, noticias.getImagem());
            
            ps.setLong(5, noticias.getIdNoticia());
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe NoticiasRepository");
        }
        return noticias;
    }

    @Override
    public void delete(Long idNoticias) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver não Encontrado. Classe NoticiaRepository");
        }
        
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("delete from noticias where id_noticia=?");
            
            ps.setLong(1, idNoticias);
            
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe NoticiaRepository");
        }
    }

    @Override
    public Noticias findOne(Long idNoticias) {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe NoticiasRepository");
        }
        Noticias noticias = new Noticias();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_noticia, id_empresa, ds_titulo, dt_publicacao, ds_noticia from noticias where id_noticia=?");
        
            ps.setLong(1, idNoticias);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                noticias.setIdNoticia(rs.getLong(1));
                noticias.getEmpresa().setIdEmpresa(rs.getLong(2));
                noticias.setTitulo(rs.getString(3));
                noticias.setDataPublicacao(rs.getObject(4, LocalDate.class));
                noticias.setNoticia(rs.getString(5));
                //noticias.setImagem(rs.getBytes(6));
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe NoticiasRepository");
        }
        return noticias;
    }

    @Override
    public List<Noticias> findAll() {
        try{
            Class.forName("org.postgresql.Driver");
        }catch(ClassNotFoundException ex){
            System.out.println(ex.getMessage());
            System.out.println("Driver Não Encontrado. Classe NoticiasRepository");
        }
        List<Noticias> listaRetorno = new ArrayList();
        try{
            Connection conexao = DriverManager.getConnection(url, user, password);
            PreparedStatement ps = conexao.prepareStatement("select id_noticia, id_empresa, ds_titulo, dt_publicacao, ds_noticia from noticias");
            
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Noticias noticias = new Noticias();
                
                noticias.setIdNoticia(rs.getLong(1));
                noticias.getEmpresa().setIdEmpresa(rs.getLong(2));
                noticias.setTitulo(rs.getString(3));
                noticias.setDataPublicacao(rs.getObject(4, LocalDate.class));
                noticias.setNoticia(rs.getString(5));
                //noticias.setImagem(rs.getBytes(6));
                
                listaRetorno.add(noticias);
            }
            ps.execute();
            ps.close();
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
            System.out.println("Erro de Conexão. Classe NoticiasRepository");
        }
        return listaRetorno;
    }
    
}
